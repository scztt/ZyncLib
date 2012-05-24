package org.artificia.zync.data.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;

import org.artificia.zync.Asset;
import org.artificia.zync.ZDBLogger;
import org.artificia.zync.data.AssetAccessor;
import org.artificia.zync.data.AssetRefAccessor;
import org.artificia.zync.data.MetadataAccessor;
import org.artificia.zync.data.ZDBFactory;
import org.artificia.zync.fs.FileSystemSettings;


public class SQLiteZDBFactory implements ZDBFactory
{
	private Connection dbConnection;
	private FileSystemSettings settings;
	
	SQLiteZDBFactory()
	{
	}
	
	public void setFileSystemSettings(FileSystemSettings inSettings)
	{
		settings = inSettings;
	}
	
	public void connectDatabase() throws SQLException, ClassNotFoundException
	{
	    Class.forName("org.sqlite.JDBC");

	    // create a database connection
		dbConnection = DriverManager.getConnection("jdbc:sqlite:" + (String)settings.get("LibraryDatabasePath"));		
	}

	public void disconnectDatabase()
	{
		try 
		{
			dbConnection.close();
		}
		catch (Exception e)
		{
			ZDBLogger.get().log(Level.SEVERE, "Failed to disconnect database. This is strange.\n" + e.getMessage());
		}
	}

	@Override
	public AssetAccessor GetAssetAccessor()
	{
		return new SQLiteAssetAccessor(dbConnection);
	}

	@Override
	public AssetRefAccessor GetAssetRefAccessor()
	{
		return new SQLiteAssetRefAccessor(dbConnection);
	}

	@Override
	public MetadataAccessor GetMetadataAccessor()
	{
		return new SQLiteMetadataAccessor(dbConnection);
	}

	public boolean isConnected()
	{
		return dbConnection != null;
	}
	
}

