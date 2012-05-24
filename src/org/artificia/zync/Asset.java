package org.artificia.zync;

import java.sql.Time;
import java.util.Date;

public class Asset {
	public String uniqueID;		// Will be numeric, eventually
	public AssetMetadata metadata;
	public Date lastUpdate;

	public Asset()
	{
		lastUpdate = new Time(new Date().getTime());
		uniqueID = "test";
		//metadata = new AssetMetadata();
	}
	
	public Boolean equals(Asset equalTo)
	{
		Boolean result = (this.metadata == equalTo.metadata);
		
		if ((this.uniqueID != null) && (equalTo.uniqueID != null))
			result = result && (this.uniqueID.equals(equalTo.uniqueID));
		
		return result;
				
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
