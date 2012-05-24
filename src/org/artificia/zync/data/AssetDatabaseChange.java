package org.artificia.zync.data;

import java.util.Date;

import org.artificia.zync.Asset;
import org.artificia.zync.data.ChangeType;

public class AssetDatabaseChange {
	public Date date;

	public String nodeOriginator;

	public String assetUniqueID;
	public ChangeType type;
	
	public Asset asset; 		// should be more like an asset specifier
}
