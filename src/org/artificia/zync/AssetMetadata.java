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
	
	public Set<String> getKeys()
	{
		return map.keySet();
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
			// @TODO Need an extra layer of type conversion to handle sibling-like types like Float and Double. Right now, just use Number in the spec for those....  
			if (expectedType == null)
			{
				map.put(key, value);
				ZDBLogger.get().warning("Key '" + key + "' is not part of metadata spec! This may cause problems later.");
			}
			else
			{
				map.put(key, expectedType.cast(value));
			}
		}
		catch (ClassCastException e)
		{
			ZDBLogger.get().warning("Value provided for key '" + key + "' not of expected type '" + expectedType.toString() + "'");
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
