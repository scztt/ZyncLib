package org.artificia.zync;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ZDBLogger extends Logger
{
	private static ZDBLogger logger;
	
	public ZDBLogger()
	{
		super("zdblogger", null);
	}

	public static ZDBLogger get()
	{
		if (logger == null)
		{
			logger = new ZDBLogger();
	        // Create a new handler that uses the simple formatter
	        try {
	            FileHandler fh = new FileHandler("~/Desktop/zdb.log");
	            fh.setFormatter(new SimpleFormatter());
	            logger.addHandler(fh);
	        } catch (IOException e) {
	        }
		}
		
		return logger;
	}
	
	public void log(String logString)
	{
		log(Level.INFO, logString);
	}
}
