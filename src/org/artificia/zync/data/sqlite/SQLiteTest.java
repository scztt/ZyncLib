package org.artificia.zync.data.sqlite;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.artificia.zync.Asset;
import org.artificia.zync.data.AccessException;
import org.artificia.zync.data.AssetAccessor;
import org.artificia.zync.data.QueryIterator;
import org.artificia.zync.fs.FileSystemSettings;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SQLiteTest
{
	SQLiteZDBFactory factory;
	@Before
	public void setUp() throws Exception
	{
		factory = new SQLiteZDBFactory();
		FileSystemSettings settings = new FileSystemSettings();
		settings.put("LibraryDatabasePath", (new File(System.getProperty("user.home"),"Desktop/ldb.db")).getPath());

		factory.setFileSystemSettings(settings);
		try
		{
			factory.connectDatabase();
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testConnectDatabase()
	{
		assertTrue(factory.isConnected());
	}

	@Test
	public void testGetAssetAccessor()
	{
		assertNotNull(factory.GetAssetAccessor());
	}
	
	@Test
	public void testInsertAsset()
	{
		AssetAccessor a = factory.GetAssetAccessor();
		Asset insert = new Asset();
		assertTrue(a.insertRecord(insert));
		
		try
		{
			Asset fromDB = null;
			QueryIterator<Asset> all = a.getAll();
			while (all.hasNext())
			{
				Asset next = all.next();
				if (next.equals(insert))
				{
					fromDB = next;
					break;
				}
			}
			
			assertNotNull(fromDB);
		}
		catch (AccessException e)
		{
			fail(e.toString());
		}
	}

}
