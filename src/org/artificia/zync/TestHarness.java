package org.artificia.zync;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import org.artificia.zync.fs.local.LocalFileSystem;

public class TestHarness
{

	public static Boolean test_LocalFileSystem()
	{
		LocalFileSystem lfs = new LocalFileSystem();
		lfs.setRootLocation(new File("/Users/Scott/Music/ZyncTest"));
		
		Vector<String> inclusions = new Vector<String>();
		inclusions.add("mp3");
		inclusions.add("flac");
		inclusions.add("m4a");
		inclusions.add("mp4");
		
		lfs.setInclusions(inclusions);
		
		Collection<AbstractFile> files = lfs.findAllFiles();
		for (AbstractFile file : files)
		{
			System.out.print(file.getPath() + "\n");
		}
		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.print("test_LocalFileSystem: " + test_LocalFileSystem());
	}

}
