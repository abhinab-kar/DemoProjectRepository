package com.demoproject.log4j;

//import statements
import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

public class Log4jDemo 
{	
	public static Logger log = Logger.getLogger(Log4jDemo.class);
	
	public static void main(String args[])
	{
		//DOMConfigurator.configure("src/com/demoproject/log4j/log4j.xml");
		log.debug("Logging Data");
		log.info("Logging Data");
		log.error("Logging Data");
	}
}
