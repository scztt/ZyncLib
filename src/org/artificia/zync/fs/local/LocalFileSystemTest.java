package org.artificia.zync.fs.local;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.Vector;

import org.artificia.zync.AbstractFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocalFileSystemTest
{
	LocalFileSystem lfs;
	
	@Before
	public void setUp() throws Exception
	{
		lfs = new LocalFileSystem();
		lfs.setRootLocation(new File("/Users/scott/Music/ZyncTest"));
		Vector<String> inclusions = new Vector<String>();
		inclusions.add("mp3");
		inclusions.add("flac");
		inclusions.add("m4a");
		inclusions.add("mp4");
		lfs.setInclusions(inclusions);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testFindAllFiles()
	{
		Collection<AbstractFile> files = this.lfs.findAllFiles();
		
		assertEquals(82, files.size());
	}

	@Test
	public void testGetRelativePathOfFile()
	{
		LocalFileSystem lfs = new LocalFileSystem();
		lfs.setRootLocation(new File("/Users/scott/Music/ZyncTest"));
		
		LocalFile file = new LocalFile("/Users/scott/Music/ZyncTest/spaceis/Space Is Only Noise/02 Colomb.mp3");
		String result = lfs.getRelativePathOfFile(file);
		
		assertEquals("spaceis/Space Is Only Noise/02 Colomb.mp3", result);
	}
	
	@Test
	public void testConstructPath()
	{
		LocalFileSystem lfs = new LocalFileSystem();
		String path = lfs.constructPath("/Users/Scott", "test.file.name.txt");
		
		assertEquals("/Users/Scott/test.file.name.txt", path);
	}

}
