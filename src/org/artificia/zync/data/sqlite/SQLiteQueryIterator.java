package org.artificia.zync.data.sqlite;

import java.sql.ResultSet;

import org.artificia.zync.AssetRef;
import org.artificia.zync.data.QueryIterator;
/*

public class SQLiteQueryIterator implements QueryIterator
{
	ResultSet resultSet;
	//FileSystem.AssetRefFactory refFactory;
	
	SQLiteQueryIterator(ResultSet inResultSet, FileSystem.AssetRefFactory inRefFactory)
	{
		resultSet = inResultSet;
		refFactory = inRefFactory;
		
		try 
		{
			resultSet.next();
		}
		catch (Exception e)
		{
			// TODO exception handling
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public boolean hasNext() 
	{
		try 
		{
			return !resultSet.isAfterLast();
		}
		catch (Exception e)
		{
			// TODO exception handling
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public AssetRef next() {
		try 
		{
			AssetRef ref = refFactory.createRef(); 			
			SqlQueryFactory.AssetRef_FromResultSet(resultSet, ref);
			resultSet.next();
			return ref;
		}
		catch (Exception e)
		{
			// TODO exception handling
			System.err.println(e.getMessage());
			return null;
		}
	}
}
*/import org.artificia.zync.fs.FileSystem;

