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
	
	@Before
	public void setUp() throws Exception
	{
		this.md = new AssetMetadata();
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
			this.md.put("integer", 1);
			this.md.put("string", "string");
			this.md.put("date", new Date());
			this.md.put("float", 9.0984350);

			assertTrue(this.md.keySet().size() == 4);

			int test = this.md.get("test");
			assertTrue(test == 1);
			String foo = this.md.get("foo");
			Date bar = this.md.get("bar");
			float random = this.md.get("LKJHGSKDJHFLIUWER)*(#$&$#FOH"); 
			
			
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
	public void testEqualsAssetMetadata()
	{
		fail("Not yet implemented"); // TODO
	}

}
