package com.demoproject.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.demoproject.controller.Controller;
import com.demoproject.exception.DBConnectionException;
import com.demoproject.exception.RecordNotFoundException;

public class UnitTest1 
{
	
	@Rule
	public ExpectedException e = ExpectedException.none();
	@Test
	public void testRecordNotFoundexception() throws RecordNotFoundException, DBConnectionException
	{
		e.expectMessage("Record Not Found");
		new Controller().getPersonById(0);
	}
}
