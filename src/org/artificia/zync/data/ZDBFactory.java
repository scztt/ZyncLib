package org.artificia.zync.data;

public interface ZDBFactory
{
	AssetAccessor GetAssetAccessor();
	AssetRefAccessor GetAssetRefAccessor();
	MetadataAccessor GetMetadataAccessor();
}
