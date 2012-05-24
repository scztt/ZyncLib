package org.artificia.zync;

import org.artificia.zync.fs.local.LocalFile;

public interface AbstractFile
{

	String getPath();
	String getName();
	long getLastModified();
	long getLength();
	
}
