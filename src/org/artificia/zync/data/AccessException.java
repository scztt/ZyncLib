package org.artificia.zync.data;

public class AccessException extends Exception
{
	Exception e;
	
	public AccessException(Exception inE)
	{
		e = inE;
	}
	
	public String toString()
	{
		return e.toString();
	}
}
