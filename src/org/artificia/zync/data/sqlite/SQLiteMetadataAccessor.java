package org.artificia.zync.data.sqlite;

import java.sql.Connection;
import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.AssetRef;
import org.artificia.zync.data.Metadata;
import org.artificia.zync.data.MetadataAccessor;
import org.artificia.zync.data.MetadataDatabaseChange;
import org.artificia.zync.data.QueryIterator;

public class SQLiteMetadataAccessor implements MetadataAccessor
{

	public SQLiteMetadataAccessor(Connection dbConnection)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyChange(MetadataDatabaseChange inAssetChange)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRecord(Metadata inAsset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRecords(Vector<Metadata> inAssets)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRecord(Metadata inAsset)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(Metadata inAsset)
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
	public QueryIterator<Metadata> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
