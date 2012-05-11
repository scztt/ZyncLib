package org.artificia.zync.data.sqlite;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.AssetRef;
import org.artificia.zync.data.AssetDatabaseChange;
import org.artificia.zync.data.AssetRefAccessor;
import org.artificia.zync.data.QueryIterator;

public class SQLiteAssetRefAccessor implements AssetRefAccessor
{

	@Override
	public void applyChange(AssetDatabaseChange inAssetChange)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRecord(org.artificia.zync.data.AssetRef inAsset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRecords(Vector<org.artificia.zync.data.AssetRef> inAssets)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRecord(org.artificia.zync.data.AssetRef inAssetRef)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(org.artificia.zync.data.AssetRef inAssetRefID)
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
	public QueryIterator<org.artificia.zync.data.AssetRef> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<org.artificia.zync.data.AssetRef> matchUsingMetadata(
			AssetMetadata inMetadata)
	{
		// TODO Auto-generated method stub
		return null;
	}


}
