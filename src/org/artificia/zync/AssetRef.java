package org.artificia.zync;

import java.io.File;
import java.sql.Time;

import org.artificia.zync.fs.FileSystem;

public class AssetRef
{
	private FileSystem fileSystem;

	public String uniqueId;
	public String assetUniqueId;
	public String name;
	public String path;
	public int size;
	public Time lastChanged;

	public AssetRef(FileSystem inFileSystem)
	{
		fileSystem = inFileSystem;
	}

	public File asLocalFile()
	{
		return new File(fileSystem.constructPath(path, name));
	}
	
	public Boolean equals(AssetRef equalTo)
	{		
		return uniqueId.equals(equalTo.uniqueId) 
				&& assetUniqueId.equals(equalTo.assetUniqueId)
				&& name.equals(equalTo.name)
				&& path.equals(equalTo.path)
				&& (size == equalTo.size);
	}
}
