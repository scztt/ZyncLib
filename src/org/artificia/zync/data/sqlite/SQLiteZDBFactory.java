package org.artificia.zync.data.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;

import org.artificia.zync.Asset;
import org.artificia.zync.FileSystemSettings;
import org.artificia.zync.ZDBLogger;
import org.artificia.zync.data.AssetAccessor;
import org.artificia.zync.data.AssetRefAccessor;
import org.artificia.zync.data.MetadataAccessor;
import org.artificia.zync.data.ZDBFactory;


public class SQLiteZDBFactory implements ZDBFactory
{
	private Connection dbConnection;
	private FileSystemSettings settings;
	
	SQLiteZDBFactory(FileSystemSettings inSettings)
	{
		this.settings = settings;
		
		try
		{
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {}

		connectDatabase();
	}
	
	public void connectDatabase()
	{
		try
		{
			// create a database connection
			dbConnection = DriverManager.getConnection("jdbc:sqlite:" + settings.getLibraryDatabasePath());
			Statement statement = dbConnection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			statement.executeUpdate(SqlQueryFactory.Asset_CreateTable());
		}
		catch(SQLException e)
		{
			ZDBLogger.get().log(Level.SEVERE, "Failed to create database connection.\n" + e.getMessage());
		}
	}

	public void disconnectDatabse()
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
	
}
