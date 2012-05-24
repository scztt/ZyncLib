package org.artificia.zync.fs;

import java.util.HashMap;
import java.util.Map;

public class FileSystemSettings
{
	Map<String, Object> dict;
	
	public FileSystemSettings()
	{
		dict = new HashMap<String, Object>();
	}
	
	public <T> T get(String string)
	{
		T result = (T)dict.get(string);
		return result;
	}
		
	public void put(String inKey, Object inValue)
	{
		dict.put(inKey, inValue);
	}
	

}
