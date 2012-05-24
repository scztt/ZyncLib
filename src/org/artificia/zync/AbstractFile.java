package org.artificia.zync;

public interface AbstractFile
{

	String getPath();
	String getName();
	long getLastModified();
	long getLength();
	
}
