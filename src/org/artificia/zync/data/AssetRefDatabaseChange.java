package org.artificia.zync.data;

import java.util.Date;

import org.artificia.zync.Node;

public class AssetRefDatabaseChange
{

	public String uniqueId;
	public String assetUniqueId;

	public String name;
	public String path;
	public int size;
	public Date lastChanged;
	
	public Date date;
	public String nodeOriginator;
	public ChangeType type;
}
