package org.artificia.zync.data.sqlite;

import java.sql.ResultSet;

import org.artificia.zync.AssetRef;
import org.artificia.zync.data.QueryIterator;

public class SQLiteQueryIterator<T> extends QueryIterator
{
	ResultSet resultSet;
	QueryIterator.TypeConvertor<ResultSet, T> convertor;
	
	SQLiteQueryIterator(ResultSet inResultSet, QueryIterator.TypeConvertor<ResultSet, T> inConvertor)
	{
		resultSet = inResultSet;
		convertor = inConvertor;
		
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
	public T next() {
		try 
		{
			T object = null;
			object = convertor.convert(resultSet);
			resultSet.next();
			return object;
		}
		catch (Exception e)
		{
			// TODO exception handling
			System.err.println(e.getMessage());
			return null;
		}
	}
}
