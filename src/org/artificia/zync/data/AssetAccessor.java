package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.data.AssetDatabaseChange;

public interface AssetAccessor
{
	public void applyChange(AssetDatabaseChange inAssetChange);
	
	public void insertRecord(Asset inAsset);
	public void insertRecords(Vector<Asset> inAssets);
	
	public void updateRecord(Asset inAsset);
	public void deleteRecord(int inAssetID);
	
	public Asset getById(int inId);
	public QueryIterator<Asset> getAll();
	public QueryIterator<Asset> matchUsingMetadata(AssetMetadata inMetadata);

}
