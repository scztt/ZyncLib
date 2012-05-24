package org.artificia.zync;

public class Node
{
	private static Node localNode;
	
	public static Node getLocalNode()
	{
		if (localNode == null)
		{
			localNode = new Node();
		}
		
		return localNode;
	}

	public String getNodeId()
	{
		return "0";
	}
}
