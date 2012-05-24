package org.artificia.zync.fs;

import java.util.Collection;

import org.artificia.zync.AbstractFile;

public interface FileSystem
{

	String constructPath(String path, String name);
	public Collection<AbstractFile> findAllFiles();
	String getRelativePathOfFile(AbstractFile file);

}
