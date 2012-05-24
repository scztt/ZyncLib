package org.artificia.zync.data.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Vector;
import java.util.Date;
import java.util.logging.Level;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.ZDBLogger;
import org.artificia.zync.data.AccessException;
import org.artificia.zync.data.AssetAccessor;
import org.artificia.zync.data.AssetDatabaseChange;
import org.artificia.zync.data.ChangeType;
import org.artificia.zync.data.QueryIterator;
import org.artificia.zync.Node;

public class SQLiteAssetAccessor implements AssetAccessor
{
	Connection db;
	
	private String insertQuery = "insert into asset (uniqueID, lastUpdate, id_metadata, id_creator) VALUES (?, ?, ?, ?)";
	private String updateQuery = "UPDATE asset SET " + "lastUpdate=?, "
			+ "id_metadata=?, " + "WHERE uniqueID = ?";
	private String allQuery = "SELECT * FROM asset";
	private String createQuery = "create table if not exists asset (" 
			+ "id INTEGER PRIMARY KEY,"
			+ "uniqueID string,"
			+ "lastUpdate timestamp,"
			+ "id_metadata integer,"
			+ "id_creator integer"
		+ ")";
		
	public SQLiteAssetAccessor(Connection inConnection)
	{
		db = inConnection;
		this.primeDatabase();
	}
	
	private void primeDatabase()
	{
		Statement statement;
		try
		{
			statement = this.db.createStatement();
			statement.execute(createQuery);
			ZDBLogger.get().log(Level.FINE, "SQL: " + statement.toString());			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class SQLiteToAssetConvertor implements QueryIterator.TypeConvertor<ResultSet, Asset>
	{
		public Asset convert(ResultSet inResult)
		{
			try
			{
				// (uniqueID, lastUpdate, id_metadata, id_creator)
				Asset asset = new Asset();
				asset.lastUpdate = new Time(inResult.getDate("lastUpdate").getTime());
				asset.metadata = null; // @TODO Get metadata from db....
				asset.uniqueID = inResult.getString("uniqueID");
				return asset;
			}
			catch (Exception e)
			{
				return null;
			}
		}		
	}
	
	@Override
	public Boolean applyChange(AssetDatabaseChange inAssetChange)
	{
		switch (inAssetChange.type)
		{
		case Add:
			return this.applyAdd(inAssetChange);
		default:
			assert false : "Incorrect or unimplemented change type!";
			return false;
		}
	}
	
	private Boolean applyAdd(AssetDatabaseChange inAssetChange)
	{
		try
		{
			// (uniqueID, lastUpdate, id_metadata, id_creator)
			PreparedStatement statement = db.prepareStatement(insertQuery);
			statement.setString(1, inAssetChange.assetUniqueID);
			statement.setTimestamp(2, new Timestamp(inAssetChange.date.getTime()));
			
			// @TODO Change sql query to support metadata and originator id
			statement.setInt(3,-1);
			statement.setInt(4, inAssetChange.nodeOriginator.hashCode());

			ZDBLogger.get().log(Level.FINE, "SQL: " + statement.toString());

			statement.execute();
			
			return true;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean insertRecord(Asset inAsset)
	{
		AssetDatabaseChange change = new AssetDatabaseChange();
		change.asset = inAsset;
		change.assetUniqueID = inAsset.uniqueID;
		change.date = new Date();
		change.nodeOriginator = Node.getLocalNode().getNodeId();
		change.type = ChangeType.Add;
		
		return this.applyChange(change);
	}

	@Override
	public Boolean insertRecords(Vector<Asset> inAssets)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean updateRecord(Asset inAsset)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean deleteRecord(int inAssetID)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Asset getById(int inId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<Asset> getAll() throws AccessException
	{
		try
		{
			Statement statement = db.createStatement();
			ResultSet rs = statement.executeQuery(allQuery);
			ZDBLogger.get().log(Level.WARNING, "SQL: " + statement.toString());			

			QueryIterator<Asset> iter = new SQLiteQueryIterator<Asset>(rs, new SQLiteToAssetConvertor());
			return iter;
		}
		catch (SQLException e)
		{
			throw new AccessException(e);
		}
	}

	@Override
	public QueryIterator<Asset> matchUsingMetadata(AssetMetadata inMetadata)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
