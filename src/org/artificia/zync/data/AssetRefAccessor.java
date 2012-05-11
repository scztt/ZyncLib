package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;

public interface AssetRefAccessor
{
	public void applyChange(AssetDatabaseChange inAssetChange);
	
	public void insertRecord(AssetRef inAsset);
	public void insertRecords(Vector<AssetRef> inAssets);
	
	public void updateRecord(AssetRef inAssetRef);
	public void deleteRecord(AssetRef inAssetRefID);
	
	public Asset getById(int inId);
	public QueryIterator<AssetRef> getAll();
	public QueryIterator<AssetRef> matchUsingMetadata(AssetMetadata inMetadata);
}
