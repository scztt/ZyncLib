package org.artificia.zync.data;

import java.util.Iterator;

public abstract class QueryIterator<T> implements Iterator, Iterable 
{
	public interface TypeConvertor<Q, T>
	{
		public T convert(Q inQ);
	}
	
	public abstract boolean hasNext();
	public abstract T next();
	
	public void remove() 
	{
	}
	
	public Iterator iterator()
	{
		return this;
	}
}
