package org.artificia.zync;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssetMetadataTest
{
	AssetMetadata md;
	Integer integer;
	String name;
	Date date;
	Float floatValue;
	
	@Before
	public void setUp() throws Exception
	{
		this.md = new AssetMetadata();

		integer = 1;
		name = "name";
		date = new Date();
		floatValue = 9.0984350f;
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testDeserialize()
	{
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSerialize()
	{
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetKeys()
	{
		try
		{
			this.md.put("integer", integer);
			this.md.put("name", name);
			this.md.put("date", date);
			this.md.put("float", floatValue);
			this.md.put("unknown", "asdf");
			
			Set<String> keys = this.md.getKeys();
			assertTrue(keys.contains("integer"));
			assertTrue(keys.contains("name"));
			assertTrue(keys.contains("date"));
			assertTrue(keys.contains("float"));
			assertTrue(keys.contains("unknown"));
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

	@Test
	public void testGetValues()
	{
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testGetPut()
	{
		try
		{
			this.md.put("integer", integer);
			this.md.put("name", name);
			this.md.put("date", date);
			this.md.put("float", floatValue);

			assertTrue(this.md.keySet().size() == 4);

			Integer resultInt = this.md.get("integer");
			assertTrue(resultInt == integer);
			
			String resultString = this.md.get("name");
			assertTrue(resultString == name);
			
			Date resultDate = this.md.get("date");
			assertTrue(resultDate == date);
			
			Float resultFloat = this.md.get("float");
			assertTrue(resultFloat == floatValue);
		}
		catch (Exception e)
		{
			fail(e.toString());
		}	
	}
	
	@Test
	public void testGetPutUnknown()
	{
		try
		{
			this.md.put("unknownInt", integer);
			this.md.put("unknownString", name);
			this.md.put("unknownDate", date);
			this.md.put("unknownFloat", floatValue);

			assertTrue(this.md.keySet().size() == 4);

			Integer resultInt = this.md.get("unknownInt");
			assertTrue(resultInt == integer);
			
			String resultString = this.md.get("unknownString");
			assertTrue(resultString == name);
			
			Date resultDate = this.md.get("unknownDate");
			assertTrue(resultDate == date);
			
			Float resultFloat = this.md.get("unknownFloat");
			assertTrue(resultFloat == floatValue);
		}
		catch (Exception e)
		{
			fail(e.toString());
		}	
	}
	
	@Test
	public void testEqualsAssetMetadata()
	{
		fail("Not yet implemented"); // TODO
	}

}
