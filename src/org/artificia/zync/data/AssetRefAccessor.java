package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.AssetRef;
import org.artificia.zync.AssetMetadata;

public interface AssetRefAccessor
{
	public Boolean applyChange(AssetRefDatabaseChange inAssetChange);
	
	public Boolean insertRecord(AssetRef inAsset);
	public Boolean insertRecords(Vector<AssetRef> inAssets);
	
	public Boolean updateRecord(AssetRef inAssetRef);
	public Boolean deleteRecord(AssetRef inAssetRefID);
	
	public AssetRef getById(int inId);
	public QueryIterator<AssetRef> getAll() throws AccessException;
	public QueryIterator<AssetRef> matchUsingMetadata(AssetMetadata inMetadata);
}
