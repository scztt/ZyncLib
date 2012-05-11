package org.artificia.zync.data;

import java.util.Vector;

import org.artificia.zync.Asset;

public interface MetadataAccessor
{
	public void applyChange(MetadataDatabaseChange inAssetChange);
	
	public void insertRecord(Metadata inAsset);
	public void insertRecords(Vector<Metadata> inAssets);
	
	public void updateRecord(Metadata inAsset);
	public void deleteRecord(Metadata inAsset);
	
	public Asset getById(int inId);
	public QueryIterator<Metadata> getAll();
}
