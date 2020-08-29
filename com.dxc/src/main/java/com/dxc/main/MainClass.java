package com.dxc.main;

import java.io.File;
import java.io.IOException;

import com.dxc.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClass {

	public static void main(String[] args) 
	{
		
		//for simple JSON data Binding
		
		//  create a ObjectMapper Object
		ObjectMapper mapper= new ObjectMapper();
		Student myStudent=null;
		
		//  handle the exception for readValue
		try {
			myStudent=mapper.readValue(new File("data/data.json"), Student.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// print out the json value that is converted to pojo
		System.out.println("firstname : "+myStudent.getFirstName());
		System.out.println("lastName : "+myStudent.getLastName());
		
		// for nested JSON data binding 
		ObjectMapper mapper2=new ObjectMapper();
		Student detailedStudent=null;
		try {
			detailedStudent=mapper2.readValue(new File("data/studentdemo.json"), Student.class);	
		} catch (Exception e) {
			e.printStackTrace();		
			}
		
		System.out.println("new student Fisrst Name : "+detailedStudent.getFirstName());
		System.out.println("new student Last Name : "+detailedStudent.getLastName());
		System.out.println("address of the new student : "+detailedStudent.getAddress());

	}

}
