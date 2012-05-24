package org.artificia.zync.fs;

import java.io.File;
import java.sql.Time;
import java.util.*;
import java.util.logging.*;

import org.artificia.zync.AbstractFile;
import org.artificia.zync.Asset;
import org.artificia.zync.AssetRef;
import org.artificia.zync.data.AssetDatabaseChange;
import org.artificia.zync.data.ChangeType;

public class Node 
//	implements AssetIDGenerator
{
    private static Logger logger;
	private static int id = 0;
	
	private FileSystem ownFileSystem;
//	private AssetDatabase allAssets;
//	private AssetRefDatabase ownAssets;
//	private ChangeDatabase ownChanges;
	
	private String nodeID;
	private int someNumber = 0;
	
	public Node(FileSystem inFileSystem)
	{
		logger = Logger.getLogger("org.artificia.zync");
		logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
		
		ownFileSystem = inFileSystem;		
//		allAssets = new AssetDatabase(ownFileSystem.getSettings());
//		ownAssets = new AssetRefDatabase(ownFileSystem);
//		ownChanges = new ChangeDatabase();
//		nodeID = Integer.toString(Node.id++);
	}
	
	public FileSystem getFileSystem()
	{
		return this.ownFileSystem;
	}
	
	public void test_populateDatabase()
	{
		// Assumes an empty database, and populates it.
		Collection<AbstractFile> files = this.ownFileSystem.findAllFiles();
		
		for (AbstractFile file : files)
		{
			Asset newAsset = new Asset();
			newAsset.uniqueID = generateUniqueAssetID();
			
			AssetDatabaseChange add = new AssetDatabaseChange();
			add.asset = newAsset;
			add.assetUniqueID = newAsset.uniqueID;
			add.date = new Date();
			add.nodeOriginator = "someNode";
			add.type = ChangeType.Add;
//			allAssets.applyChange(add);
			
			AssetRef newAssetRef = new AssetRef(this.ownFileSystem);
			newAssetRef.uniqueID = newAsset.uniqueID;
			newAssetRef.name = file.getName();
			//newAssetRef.path = PathUtils.getRelativePath(file.getParentFile().toString(), this.ownFileSystem.getRootPath(), "/");
			newAssetRef.path = this.ownFileSystem.getRelativePathOfFile(file);
			newAssetRef.lastChanged = new Time(file.getLastModified());
			newAssetRef.size = (int)file.getLength();
			//ownAssets.addAssetRef(newAssetRef);
		}
	}
	
	public void test_updateDatebase()
	{
/*		
		Date startTime = new Date();
		
		LinkedList<AssetRef> missingFiles = new LinkedList<AssetRef>();
		LinkedList<AssetRef> changedFiles = new LinkedList<AssetRef>();
		LinkedList<File> existingFiles = new LinkedList<File>();
		LinkedList<File> newFiles;
		
		// Iterate all AssetRef's and match them to on-disk assets.
		//AssetRefIterator iter = ownAssets.iterator();
		while (iter.hasNext())
		{
			AssetRef ref = iter.next();
			File localFile = new File(ownFileSystem.constructPath(ref.path, ref.name));
			
			if (!localFile.exists())
				missingFiles.add(ref);
			else 
			{
				if(localFile.length() != ref.size || localFile.lastModified() != ref.lastChanged.getTime())
					changedFiles.add(ref); 
				existingFiles.add(localFile);
			}
		}
		
		// Iterate over all files to check for new ones
		newFiles = this.ownFileSystem.findAllAssets();

		newFiles.removeAll(existingFiles);
		
		Date endTime = new Date();

		logger.fine("existing:\n " + existingFiles);
		logger.fine("new:\n " + newFiles);
		logger.fine("missing:\n " + missingFiles);
		logger.fine("changed:\n " + changedFiles);
		logger.fine("time: " + ((endTime.getTime() - startTime.getTime())));
		
		// Reconcile changes
		
		// First: construct proto-assets for all new files
		LinkedList<AssetRef> protoNewAssetRefs = new LinkedList<AssetRef>();
		Iterator<File> newFileIter = newFiles.iterator();
		while (newFileIter.hasNext())
		{
			File file = newFileIter.next();
			AssetRef newAssetRef = new AssetRef(this.ownFileSystem);
			newAssetRef.name = file.getName();
			newAssetRef.path = PathUtils.getRelativePath(file.getParentFile().toString(), this.ownFileSystem.getRootPath(), "/");
			newAssetRef.lastChanged = new Time(file.lastModified());
			newAssetRef.size = (int)file.length();
			protoNewAssetRefs.add(newAssetRef);
		}
		
		// First: handle changed files
		// @TODO
		
		// Second: Try to match missing files up to new files, because they may have been simply moved
		Iterator<AssetRef> missingIter = missingFiles.iterator();
		while (missingIter.hasNext())
		{
			Iterator<AssetRef> candidateIter = protoNewAssetRefs.iterator();
			while (candidateIter.hasNext())
			{
				AssetRef missing = missingIter.next();
				AssetRef candidate = candidateIter.next();
				System.out.println(missing.path);
				System.out.println(candidate.path);
				
				if (missing.name.equals(candidate.name))
				{
					if (missing.size == candidate.size)
					{
						candidate.uniqueID = missing.uniqueID;
						ownAssets.updateAssetRef(candidate);
						missingIter.remove();
						candidateIter.remove();
						break;
					}
					else 
					{
						candidate.uniqueID = missing.uniqueID;
						ownAssets.updateAssetRef(candidate);
						missingIter.remove();
						candidateIter.remove();
						logger.warning("Swapped " + candidate.name + " for " + missing.name + " even though size was different!");
						break;
					}
				}
				else if (missing.path.equals(candidate.path))
				{
					if (missing.size == candidate.size)
					{
						candidate.uniqueID = missing.uniqueID;
						ownAssets.updateAssetRef(candidate);
						missingIter.remove();
						candidateIter.remove();
						break;
					}
					else
					{
						// Compare metadata?
						logger.warning(missing.path + " and " + candidate.path + " were not swapped.");
					}
				}
				else if (missing.size == candidate.size)
				{
					logger.warning(missing.name + " and " + candidate.name + " were the same size, but were not switched.");
					// Only size is the same
					// Should compare metadata
				}
				// More metadata comparisons?
			}
		}
		
		// Third: build list of new files for addition to central database
		Iterator<AssetRef> newIter = protoNewAssetRefs.iterator();
		while(newIter.hasNext())
		{
			AssetRef ref = newIter.next();
			AssetMetadata metadata = AssetMetadata.getMetadataFromAssetRef(ref);
			
			// Find candidate files already in the db based on metadata.
			Vector<Asset> candidates  = allAssets.findExistingAsset(metadata);
		}
		*/
	}
	
	public void test_dumpDatabase()
	{
	}
	
	public String generateUniqueAssetID()
	{
		return (new Date()).getTime() + "." +  this.nodeID + "." + (someNumber++);
	}
}
