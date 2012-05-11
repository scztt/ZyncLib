package org.artificia.zync.data.sqlite;

import java.sql.ResultSet;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetRef;

public class SqlQueryFactory {

	// create table metadata (artist string, title string, album string, year integer, composer string, duration integer, fileType string, bitRate integer, sampleRate integer)
	
	///////////////////////////////////////////////////////////////
	// AssetRef
	public static String AssetRef_CreateTable()
	{
		String str = "create table assetref (" 
				+ "id INTEGER PRIMARY KEY,"
				+ "uniqueID string,"
				+ "path string,"
				+ "name string,"
				+ "size int,"
				+ "lastChanged time"
				+ ")";
		return str;	
	}

	public static String AssetRef_Insert()
	{		
		return "insert into assetref (uniqueID, path, name, size, lastChanged) VALUES (?, ?, ?, ?, ?)";
	}
	
	///////////////////////////////////////////////////////////////
	// Asset
	public static String Asset_CreateTable()
	{
		String str = "create table asset (" 
				+ "id INTEGER PRIMARY KEY,"
				+ "uniqueID string,"
				+ "lastUpdate date,"
				+ "id_metadata integer"
				+ ")";
		return str;	
	}

	public static String Asset_Insert(Asset inAsset)
	{
//		String str = "insert into asset (uniqueID, lastUpdate, metadata) VALUES ("
//				+ "'" + inAsset.uniqueID + "',"
//				+ "'" + inAsset.lastUpdate + "',"
//				+ "'" + inAsset.metadata + "')";
		String str = "insert into asset (uniqueID, lastUpdate, metadata) VALUES (?, ?, ?)";
		return str;
	}
	
	public static String Asset_TitleArtistAlbumQuery()
	{
		String str = "select * from asset ";
		return str;
	}

	public static String AssetRef_QueryByUniqueId(String inUniqueId) {
		String str = String.format("select * from assetref where uniqueID = '%'", inUniqueId);
		return str;
	}

	public static AssetRef AssetRef_FromResultSet(ResultSet result, AssetRef inRef) {
		try 
		{
			if (true)
			{
				inRef.name = result.getString("name");
				inRef.path = result.getString("path");
				inRef.uniqueID = result.getString("uniqueID");
				inRef.size = result.getInt("size");
				inRef.lastChanged = result.getTime("lastChanged");
			}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());						
		}
		
		return inRef;
	}
	
	public static String AssetRef_UpdateByUniqueID(String inUniqueID)
	{
		return "UPDATE assetref SET "
				+ "path=?, "
				+ "name=?, "
				+ "size=?, "
				+ "lastChanged=? "
				+ "WHERE uniqueID = '" + inUniqueID + "'";
	}

	public static String AssetRef_All()
	{
		return "select * from assetref";
	}
}
