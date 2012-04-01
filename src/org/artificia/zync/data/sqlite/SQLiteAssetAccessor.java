package org.artificia.zync.data.sqlite;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetDatabaseChange;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.data.AssetAccessor;
import org.artificia.zync.data.QueryIterator;

public class SQLiteAssetAccessor implements AssetAccessor
{

	@Override
	public void applyChange(AssetDatabaseChange inAssetChange)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAsset(Asset inAsset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAssets(Vector<Asset> inAssets)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAsset(Asset inAsset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAsset(int inAssetID)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Asset getAssetByID(int inAssetID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<Asset> getAssets()
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
