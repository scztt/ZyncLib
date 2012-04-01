package org.artificia.zync;

import java.io.File;
import java.sql.Time;

public class AssetRef {
	private FileSystem fileSystem;
	
	public String uniqueID;		// Will be numeric, eventually
	public String name;
	public String path;			// FileSystem.rootPath +/+ Asset.path +/+ Asset.name == full uri
	public int size;
	public Time lastChanged;
	
	AssetRef(FileSystem inFileSystem)
	{
		fileSystem = inFileSystem;
	}
	
	public File asLocalFile()
	{
		return new File(fileSystem.constructPath(path, name));
	}
}
