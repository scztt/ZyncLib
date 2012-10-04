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
				+ "uniqueId string,"
				+ "path string,"
				+ "name string,"
				+ "size int,"
				+ "lastChanged time"
				+ ")";
		return str;	
	}

	public static String AssetRef_Insert()
	{		
		return "insert into assetref (uniqueId, path, name, size, lastChanged) VALUES (?, ?, ?, ?, ?)";
	}
	
	///////////////////////////////////////////////////////////////
	// Asset
	public static String Asset_CreateTable()
	{
		String str = "create table if not exists asset (" 
					+ "id INTEGER PRIMARY KEY,"
					+ "uniqueId string,"
					+ "lastUpdate date,"
					+ "id_metadata integer"
				+ ")";
		return str;	
	}

	public static String Asset_Insert(Asset inAsset)
	{
//		String str = "insert into asset (uniqueId, lastUpdate, metadata) VALUES ("
//				+ "'" + inAsset.uniqueId + "',"
//				+ "'" + inAsset.lastUpdate + "',"
//				+ "'" + inAsset.metadata + "')";
		String str = "insert into asset (uniqueId, lastUpdate, metadata) VALUES (?, ?, ?)";
		return str;
	}
	
	public static String Asset_TitleArtistAlbumQuery()
	{
		String str = "select * from asset ";
		return str;
	}

	public static String AssetRef_QueryByUniqueId(String inUniqueId) {
		String str = String.format("select * from assetref where uniqueId = '%'", inUniqueId);
		return str;
	}

	public static AssetRef AssetRef_FromResultSet(ResultSet result, AssetRef inRef) {
		try 
		{
			if (true)
			{
				inRef.name = result.getString("name");
				inRef.path = result.getString("path");
				inRef.uniqueId = result.getString("uniqueId");
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
				+ "WHERE uniqueId = '" + inUniqueID + "'";
	}

	public static String AssetRef_All()
	{
		return "select * from assetref";
	}
}
