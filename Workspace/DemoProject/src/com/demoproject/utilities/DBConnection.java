package com.demoproject.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.demoproject.exception.DBConnectionException;

public class DBConnection 
{
	private Connection connection;
	
	public Connection getConnectionDetails() throws DBConnectionException
	{
		this.connection = null;
		try
		{
			//Loading the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//creating the connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abcd@1234");
			//connection = DriverManager.getConnection("jdbc:oracle:thin:system/abcd@1234:@localhost:1521:xe");
			
			return connection;
		}
		catch(ClassNotFoundException e)
		{
			Logger log = Logger.getLogger(DBConnection.class);
			log.warn(e.getMessage(), e);
			throw new DBConnectionException();
		}
		catch (SQLException e) 
		{
			Logger log = Logger.getLogger(DBConnection.class);
			log.warn(e.getMessage(), e);
			throw new DBConnectionException();
		}
		catch (Exception e) {
			// TODO: handle exception
			Logger log = Logger.getLogger(DBConnection.class);
			log.warn(e.getMessage(), e);
			throw new DBConnectionException();
		}
		
	}
	
	//For closing the DB Connection Created
	public void closeDBConnection() throws DBConnectionException
	{
		try 
		{
			if(this.connection!=null)
				connection.close();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger log = Logger.getLogger(DBConnection.class);
			log.warn(e.getMessage(), e);
			throw new DBConnectionException();
		}
	}
	
}