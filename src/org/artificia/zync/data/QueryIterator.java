package org.artificia.zync.data;

public interface QueryIterator<T>
{
	public boolean hasNext();
	public T next();
}
