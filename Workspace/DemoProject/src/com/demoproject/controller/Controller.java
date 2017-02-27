package com.demoproject.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.demoproject.bean.Person;
import com.demoproject.dao.PersonDao;
import com.demoproject.exception.DBConnectionException;
import com.demoproject.exception.RecordNotFoundException;

public class Controller 
{
	public Person getPersonById(Integer id) throws RecordNotFoundException, DBConnectionException
	{
		try
		{
			PersonDao personDao = new PersonDao();
			Person person = personDao.getPersonById(id);
			return person;
		}
		catch(Exception e)
		{
			Logger log = Logger.getLogger(Controller.class);
			log.warn(e.getMessage(), e);
			throw e;
		}
		
	}

	public ArrayList<Person> getPersonByAddress(String address) throws DBConnectionException, RecordNotFoundException
	{
		try
		{
			PersonDao personDao = new PersonDao();
			ArrayList<Person> personList = personDao.getPersonByAddress(address);
			return personList;
		}
		catch(Exception e)
		{
			Logger log = Logger.getLogger(Controller.class);
			log.warn(e.getMessage(), e);
			throw e;
		}
	}
}
