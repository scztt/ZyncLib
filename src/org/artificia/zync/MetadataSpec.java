package org.artificia.zync;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MetadataSpec
{
	private Map<String, Class> dataTypes;
	
	public MetadataSpec()
	{
		// @TODO get rid of this
		dataTypes = new HashMap<String, Class>();
		dataTypes.put("name", String.class);
		dataTypes.put("integer", Integer.class);
		dataTypes.put("date", Date.class);
		dataTypes.put("float", Number.class);
	}

	public Class getTypeForKey(String key)
	{
		return dataTypes.get(key);
	}

}
