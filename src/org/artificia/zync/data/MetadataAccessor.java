package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetDatabaseChange;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.AssetRef;

public interface MetadataAccessor
{
	public void applyChange(AssetDatabaseChange inAssetChange);
	
	public void insertAsset(Asset inAsset);
	public void insertAssets(Vector<Asset> inAssets);
	
	public void updateAsset(Asset inAsset);
	public void deleteAsset(Asset inAsset);
	
	//public Asset getAssetByID(int inAssetID);
	public QueryIterator<AssetRef> getAssets();
	public QueryIterator<AssetRef> matchUsingMetadata(AssetMetadata inMetadata);
}
