package org.artificia.zync;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.Any;

public class AssetMetadata
{
	private MetadataSpec spec;
	private Map<String, Object> map;
	
	public AssetMetadata()
	{
		// @TODO remove this
		this.spec = new MetadataSpec();
		this.map = new HashMap<String, Object>();
	}
	
	public static AssetMetadata deserialize(String inSerialized)
	{
		return null;
	}
	
	public String serialize()
	{
		return null;
	}
	
	public Set<Object> getValues()
	{
		return null;		
	}
	
	public Boolean equals(AssetMetadata inMD)
	{
		// @TODO an actual equals method here...
		return true;
	}

	public Set<String> keySet()
	{
		return map.keySet();
	}

	public void put(String key, Object value) throws Exception
	{
		Class<?> expectedType = spec.getTypeForKey(key);
		try
		{
			map.put(key, expectedType.getClass().cast(value));
		}
		catch (ClassCastException e)
		{
			throw e;
		}
	}
	
	public <T> T get(String key) throws ClassCastException
	{
		
		try
		{
			T value = (T)map.get(key);
			return value;
		}
		catch (ClassCastException e)
		{
			ZDBLogger.get().log("Trying to get an incorrect type from field " + key + " (" + spec.getTypeForKey(key).getName() + ")");
			return null;
		}
		
	}
}
