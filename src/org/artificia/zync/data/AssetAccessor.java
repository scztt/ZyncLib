package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetDatabaseChange;
import org.artificia.zync.AssetMetadata;

public interface AssetAccessor
{
	public void applyChange(AssetDatabaseChange inAssetChange);
	
	public void insertAsset(Asset inAsset);
	public void insertAssets(Vector<Asset> inAssets);
	
	public void updateAsset(Asset inAsset);
	public void deleteAsset(int inAssetID);
	
	public Asset getAssetByID(int inAssetID);
	public QueryIterator<Asset> getAssets();
	public QueryIterator<Asset> matchUsingMetadata(AssetMetadata inMetadata);
}
