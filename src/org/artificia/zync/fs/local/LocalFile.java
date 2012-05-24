package org.artificia.zync.fs.local;

import java.io.File;
import java.io.IOException;

import org.artificia.zync.AbstractFile;

public class LocalFile implements AbstractFile
{
	File file;
	
	public LocalFile(File inFile)
	{
		this.file = inFile;
	}

	LocalFile(String string)
	{
		this(new File(string));
	}

	@Override
	public String getPath()
	{
		String path = "";
		try
		{
			path = this.file.getCanonicalPath();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			assert false;
			e.printStackTrace();
		}
		return path;
	}

	@Override
	public String getName()
	{
		return this.file.getName();
	}

	@Override
	public long getLastModified()
	{
		return this.file.lastModified();
	}

	@Override
	public long getLength()
	{
		return this.file.length();
	}
	
	public File getFile()
	{
		return file;
	}
}
