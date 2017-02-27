package com.demoproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

import org.apache.log4j.Logger;

import com.demoproject.bean.Person;
import com.demoproject.exception.DBConnectionException;
import com.demoproject.exception.RecordNotFoundException;
import com.demoproject.utilities.DBConnection;


public class PersonDao 
{
	private DBConnection dbConnection;
	private Connection connection;
	
	public PersonDao() throws DBConnectionException
	{
		// TODO Auto-generated constructor stub
		try
		{
			this.dbConnection = new DBConnection();
			this.connection = dbConnection.getConnectionDetails();
		}
		catch(Exception e)
		{
			Logger log = Logger.getLogger(PersonDao.class);
			log.warn(e.getMessage(), e);
			throw new DBConnectionException();
		}
	}

	public Person getPersonById(Integer id) throws RecordNotFoundException, DBConnectionException
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Person> personList = new ArrayList<Person>();
		try 
		{
			preparedStatement = connection.prepareStatement("select * from ORACLE_SCHEMA.PERSON");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Person person = new Person();
				person.setId(resultSet.getInt(1));
				person.setName(resultSet.getString(2));
				person.setAddress(resultSet.getString(3));
				
				personList.add(person);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger log = Logger.getLogger(PersonDao.class);
			log.warn(e.getMessage(), e);
		}
		finally 
		{	
			try
			{
				dbConnection.closeDBConnection();
			}
			catch(Exception e)
			{
				Logger log = Logger.getLogger(PersonDao.class);
				log.warn(e.getMessage(), e);
				throw new DBConnectionException();
			}
		}
		
		
		ListIterator<Person> listIterator = personList.listIterator();
		try{
			while(listIterator.hasNext())
			{
				Person person = listIterator.next();

				if(person.getId().equals(id))
					return person;
			}
			throw new RecordNotFoundException();
		}
		catch(Exception e)
		{
			Logger log = Logger.getLogger(PersonDao.class);
			log.warn(e.getMessage(), e);
			throw e;
		}
		
	}
		
	public ArrayList<Person> getPersonByAddress(String address) throws DBConnectionException, RecordNotFoundException
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Person> personList = new ArrayList<Person>();
		try 
		{
			preparedStatement = connection.prepareStatement("select * from ORACLE_SCHEMA.PERSON where address=?");
			preparedStatement.setString(1, address);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Person person = new Person();
				person.setId(resultSet.getInt(1));
				person.setName(resultSet.getString(2));
				person.setAddress(resultSet.getString(3));
				
				personList.add(person);
			}
			
			if(personList.isEmpty())
			{
				throw new RecordNotFoundException();
			}
			
			return personList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger log = Logger.getLogger(PersonDao.class);
			log.warn(e.getMessage(), e);
			throw new DBConnectionException();
		}
		catch (Exception e) {
			// TODO: handle exception
			Logger log = Logger.getLogger(PersonDao.class);
			log.warn(e.getMessage(), e);
			throw e;
		}
		finally 
		{	
			try
			{
				dbConnection.closeDBConnection();
			}
			catch(Exception e)
			{
				Logger log = Logger.getLogger(PersonDao.class);
				log.warn(e.getMessage(), e);
				throw new DBConnectionException();
			}
		}
	}
}
