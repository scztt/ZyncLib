package org.artificia.zync.data.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;

import org.artificia.zync.Asset;
import org.artificia.zync.AssetMetadata;
import org.artificia.zync.AssetRef;
import org.artificia.zync.Node;
import org.artificia.zync.ZDBLogger;
import org.artificia.zync.data.AccessException;
import org.artificia.zync.data.AssetDatabaseChange;
import org.artificia.zync.data.AssetRefAccessor;
import org.artificia.zync.data.AssetRefDatabaseChange;
import org.artificia.zync.data.ChangeType;
import org.artificia.zync.data.QueryIterator;
import org.artificia.zync.fs.FileSystem;

public class SQLiteAssetRefAccessor implements AssetRefAccessor
{
	// /////////////////////////////////////////////////////////////////////////
	// Queries
	private String insertQuery = "insert into assetref (uniqueId, assetUniqueId, name, path, size, file_changed_date, last_updated, id_metadata, id_creator) VALUES (?,?,?,?,?,?,?,?,?)";

	private String updateQuery = "UPDATE assetref SET " + "lastUpdate=?, "
			+ "id_metadata=?, " + "WHERE uniqueId = ?";

	private String allQuery = "SELECT * FROM assetref";

	private String createQuery = "create table if not exists assetref ("
			+ "id INTEGER PRIMARY KEY," + "uniqueId string,"
			+ "assetUniqueId string," + "name string," + "path string,"
			+ "size int," + "file_changed_date timestamp,"

			+ "last_updated timestamp," + "id_metadata integer,"
			+ "id_creator integer" + ")";

	FileSystem filesystem;

	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	// SQLite to Asset
	private class SQLiteToAssetRefConvertor implements
			QueryIterator.TypeConvertor<ResultSet, AssetRef>
	{
		private FileSystem filesystem;

		public SQLiteToAssetRefConvertor(FileSystem inFilesystem)
		{
			filesystem = inFilesystem;
		}

		public AssetRef convert(ResultSet inResult)
		{
			try
			{
				// (uniqueId, assetUniqueId, name, path, size,
				// file_changed_date, last_updated, id_metadata, id_creator)
				AssetRef assetref = new AssetRef(filesystem);

				assetref.uniqueId = inResult.getString("uniqueId");
				assetref.assetUniqueId = inResult.getString("assetUniqueId");

				assetref.name = inResult.getString("name");
				assetref.path = inResult.getString("path");
				assetref.size = inResult.getInt("size");
				assetref.lastChanged = new Time(inResult.getTimestamp("file_changed_date").getTime());

				return assetref;
			}
			catch (Exception e)
			{
				return null;
			}
		}
	}

	Connection db;

	public SQLiteAssetRefAccessor(Connection inConnection)
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

	@Override
	public Boolean applyChange(AssetRefDatabaseChange inAssetRefChange)
	{
		switch (inAssetRefChange.type)
		{
		case Add:
			return this.applyAdd(inAssetRefChange);
		default:
			assert false : "Incorrect or unimplemented change type!";
			return false;
		}
	}

	private Boolean applyAdd(AssetRefDatabaseChange inAssetRefChange)
	{
		try
		{
			// (uniqueId, assetUniqueId, name, path, size, file_changed_date,
			// last_updated, id_metadata, id_creator)
			PreparedStatement statement = db.prepareStatement(insertQuery);
			statement.setString(1, inAssetRefChange.uniqueId);
			statement.setString(2, inAssetRefChange.assetUniqueId);
			statement.setString(3, inAssetRefChange.name);
			statement.setString(4, inAssetRefChange.path);
			statement.setInt(5, inAssetRefChange.size);
			statement.setTimestamp(6, new Timestamp(
					inAssetRefChange.lastChanged.getTime()));

			statement.setTimestamp(7,
					new Timestamp(inAssetRefChange.date.getTime()));
			statement.setString(8, inAssetRefChange.nodeOriginator);

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
	public Boolean insertRecord(AssetRef inAsset)
	{
		AssetRefDatabaseChange change = new AssetRefDatabaseChange();

		change.uniqueId = inAsset.uniqueId;
		change.assetUniqueId = inAsset.assetUniqueId;
		change.name = inAsset.name;
		change.path = inAsset.path;
		change.size = inAsset.size;
		change.lastChanged = inAsset.lastChanged;

		change.date = new Date();
		change.nodeOriginator = Node.getLocalNode().getNodeId();
		change.type = ChangeType.Add;

		return this.applyChange(change);
	}

	@Override
	public Boolean insertRecords(Vector<AssetRef> inAssets)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateRecord(AssetRef inAssetRef)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteRecord(AssetRef inAssetRefID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetRef getById(int inId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryIterator<AssetRef> getAll() throws AccessException
	{
		try
		{
			Statement statement = db.createStatement();
			ResultSet rs = statement.executeQuery(allQuery);
			ZDBLogger.get().log(Level.WARNING, "SQL: " + statement.toString());

			QueryIterator<AssetRef> iter = new SQLiteQueryIterator<AssetRef>(
					rs, new SQLiteToAssetRefConvertor(filesystem));
			return iter;
		}
		catch (SQLException e)
		{
			throw new AccessException(e);
		}
	}

	@Override
	public QueryIterator<AssetRef> matchUsingMetadata(AssetMetadata inMetadata)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
