package org.artificia.zync;

import java.util.Date;

public class Asset {
	public String uniqueID;		// Will be numeric, eventually
	public AssetMetadata metadata;
	public Date lastUpdate;

	Asset()
	{
		lastUpdate = new Time(new Date().getTime());
		metadata = new AssetMetadata();
	}
	
	public String toString()
	{
		String str = "";
		str += "Asset {";
		str += "uniqueID:" + uniqueID.toString() + ", ";
		str += "lastUpdate:" + lastUpdate.toString() + ", ";
		str += "metadata:" + metadata.toString();
		str += "}\n";
		return str;
	}
}
