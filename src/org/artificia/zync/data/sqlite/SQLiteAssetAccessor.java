package org.artificia.zync.data.sqlite;

import java.sql.Connection;
import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.data.AssetAccessor;
import org.artificia.zync.data.AssetDatabaseChange;
import org.artificia.zync.data.QueryIterator;

public class SQLiteAssetAccessor implements AssetAccessor
{
	private String insertQuery = "insert into asset (uniqueID, lastUpdate, id_metadata) VALUES (?, ?, ?)";
	private String updateQuery = "UPDATE asset SET " + "lastUpdate=?, "
			+ "id_metadata=?, " + "WHERE uniqueID = ?";

	public SQLiteAssetAccessor(Connection dbConnection)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyChange(AssetDatabaseChange inAssetChange)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRecord(Asset inAsset)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRecords(Vector<Asset> inAssets)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRecord(Asset inAsset)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRecord(int inAssetID)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Asset getById(int inId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<Asset> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<Asset> matchUsingMetadata(AssetMetadata inMetadata)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
