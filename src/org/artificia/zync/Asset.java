package org.artificia.zync;

import java.sql.Time;
import java.util.Date;

public class Asset {
	public String uniqueId;		// Will be numeric, eventually
	public AssetMetadata metadata;
	public Date lastUpdate;
	public Object name;

	public Asset()
	{
		lastUpdate = new Time(new Date().getTime());
		uniqueId = "test";
		metadata = new AssetMetadata();
	}
	
	public Asset(AssetMetadata inMeta)
	{
		lastUpdate = new Time(new Date().getTime());
		uniqueId = "test";
		metadata = inMeta;
	}
	
	public Boolean equals(Asset equalTo)
	{
		Boolean result = this.metadata.equals(equalTo.metadata);
		
		if ((this.uniqueId != null) && (equalTo.uniqueId != null))
			result = result && (this.uniqueId.equals(equalTo.uniqueId));
		
		return result;
	}
	
	public String toString()
	{
		String str = "";
		str += "Asset {";
		str += "uniqueId:" + uniqueId.toString() + ", ";
		str += "lastUpdate:" + lastUpdate.toString() + ", ";
		str += "metadata:" + metadata.toString();
		str += "}\n";
		return str;
	}
}
