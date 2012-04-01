package org.artificia.zync.data.sqlite;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetDatabaseChange;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.AssetRef;
import org.artificia.zync.data.MetadataAccessor;
import org.artificia.zync.data.QueryIterator;

public class SQLiteMetadataAccessor implements MetadataAccessor
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
	public void deleteAsset(Asset inAsset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public QueryIterator<AssetRef> getAssets()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<AssetRef> matchUsingMetadata(AssetMetadata inMetadata)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
