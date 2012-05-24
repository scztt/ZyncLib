package org.artificia.zync.fs.local;

import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import org.apache.commons.io.*;
import org.artificia.zync.AbstractFile;
import org.artificia.zync.fs.FileSystem;

public class LocalFileSystem implements FileSystem
{
	LocalFile rootFolder;
	Vector<String> inclusions;
	Vector<String> exclusions;
	
	public LocalFileSystem()
	{
		inclusions =  new Vector<String>();
		exclusions =  new Vector<String>();
	}
	
	public void setRootLocation(File inFolder)
	{
		assert inFolder.isDirectory();
		assert inFolder.exists();
		
		rootFolder = new LocalFile(inFolder);
	}
	
	public Vector<String> getInclusions()
	{
		return inclusions;
	}
	
	public void setInclusions(Vector<String> inInclusions)
	{
		this.inclusions = inInclusions;
	}
	
	public Vector<String> getExclusions()
	{
		return exclusions;
	}
	
	public void setExclusions(Vector<String> inExclusions)
	{
		this.exclusions = inExclusions;
	}
	
	public Collection<AbstractFile> findAllFiles()
	{
		LinkedList<AbstractFile> files = new LinkedList<AbstractFile>();
		
		String[] inclusionArray = new String[this.inclusions.size()];
		this.inclusions.copyInto(inclusionArray);
		
		Iterator<File> fileIter = FileUtils.iterateFiles(rootFolder.getFile(), inclusionArray, true);
		while (fileIter.hasNext())
		{
			// @TODO Exclusions
			files.add(new LocalFile(fileIter.next()));
		}			
		
		return files;
	}

	@Override
	public String constructPath(String path, String name)
	{
		File file = new File(path, name);
		return file.getAbsolutePath();
	}

	@Override
	public String getRelativePathOfFile(AbstractFile file)
	{
		try
		{
			LocalFile localFile = (LocalFile)file;
			return rootFolder.getFile().toURI().relativize(localFile.getFile().toURI()).getPath();
		}
		catch (java.lang.ClassCastException e)
		{
			assert false;
			return "";
		}
	}
}
