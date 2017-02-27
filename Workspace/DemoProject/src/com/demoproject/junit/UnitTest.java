package com.demoproject.junit;

import org.junit.Assert;
import org.junit.Test;

import com.demoproject.controller.Controller;
import com.demoproject.exception.DBConnectionException;
import com.demoproject.exception.RecordNotFoundException;

public class UnitTest 
{

	@Test
	public void validatePersonName() throws RecordNotFoundException, DBConnectionException
	{
		Assert.assertEquals("Abhinab Kar", new Controller().getPersonById(1).getName());
	}
	
	@Test
	public void validatePersonAddress() throws RecordNotFoundException, DBConnectionException
	{
		Assert.assertEquals("Dumka", new Controller().getPersonById(1).getAddress());
	}
}
