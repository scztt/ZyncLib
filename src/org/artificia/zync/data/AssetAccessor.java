package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.data.AssetDatabaseChange;

public interface AssetAccessor
{
	public Boolean applyChange(AssetDatabaseChange inAssetChange);
	
	public Boolean insertRecord(Asset inAsset);
	public Boolean insertRecords(Vector<Asset> inAssets);
	
	public Boolean updateRecord(Asset inAsset);
	public Boolean deleteRecord(int inAssetID);
	
	public Asset getById(int inId) throws AccessException;
	public QueryIterator<Asset> getAll() throws AccessException;
	public QueryIterator<Asset> matchUsingMetadata(AssetMetadata inMetadata) throws AccessException;

}
