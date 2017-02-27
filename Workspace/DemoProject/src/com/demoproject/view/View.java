package com.demoproject.view;

import java.util.ArrayList;
import java.util.ListIterator;
import org.apache.log4j.Logger;
import com.demoproject.bean.Person;
import com.demoproject.controller.Controller;


public class View 
{
	
	public void displayPersonInfoById(Integer id)
	{
		
		try
		{
		Controller controller = new Controller();
		Person person = controller.getPersonById(id);
				
		System.out.println("---------------Person Details----------------\n");
		System.out.println("Id"+"\t"+"Name"+"\t\t\t"+"Address");
		System.out.println(person.getId()+"\t"+person.getName()+"\t\t"+person.getAddress());
		}
		catch(Exception e)
		{
			Logger log = Logger.getLogger(View.class);
			log.warn(e.getMessage(), e);
			System.out.println(e.getMessage());
		}
	}
	
	public void displayPersonByAddress(String address)
	{
		try
		{
		Controller controller = new Controller();
		ArrayList<Person> personList = controller.getPersonByAddress(address);
		
		ListIterator<Person> personLists = personList.listIterator();
		System.out.println("---------------Person Details----------------\n");
		System.out.println("Id"+"\t"+"Name"+"\t\t\t"+"Address");
		
		while(personLists.hasNext())
		{
			Person person = personLists.next();
			System.out.println(person.getId()+"\t"+person.getName()+"\t\t"+person.getAddress());
		}
		
		}
		catch(Exception e)
		{
			Logger log = Logger.getLogger(View.class);
			log.warn(e.getMessage(), e);
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String args[])
	{
		View view = new View();
		
		//view.displayPersonInfoById(8);
		view.displayPersonByAddress("");
	}
}
