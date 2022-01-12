//as soon as i click submit button,request first comes on this servlet via xml .
package com.practice.controller;	

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.practice.dao.StudentDao;
import com.practice.entities.Student;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

//@WebServlet(value={"/register"})
public class StudentServlet extends HttpServlet {
	//constructor with super()is called by jvm by default
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao = new StudentDao();
	
	//this get me gender values loaded on loading of registration page 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Map<Integer, String> genderTypeList =studentDao.registerStudent();			
		request.setAttribute("genderTypeList", genderTypeList); 
		request.getRequestDispatcher("/student.jsp").forward(request, response);		
			}	
	
//this takes the entire student data enterd in form to db via dao for insertion
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	String firstName = request.getParameter("fname");//this field in bracket comes from jsp file  	
    	String lastName = request.getParameter("lname");
    	String guardianName = request.getParameter("guardianname");
    	String dob = request.getParameter("dob");
    	int grade = Integer.parseInt(request.getParameter("grade"));
    	int rollNo = Integer.parseInt(request.getParameter("rollno"));
    	int contactNo = Integer.parseInt(request.getParameter("contact"));
    	int gender = Integer.parseInt(request.getParameter("selectGender"));
    	String email = request.getParameter("email");
    	
    	int houseNo = Integer.parseInt(request.getParameter("hno"));
    	String street = request.getParameter("street");
    	String city = request.getParameter("city");//this field in bracket comes from jsp file    	
    	String state = request.getParameter("state");
    	String postalCode = request.getParameter("pcode");
    	
    	Student student = new Student();
    	student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setGuardianName(guardianName);
		student.setDob(dob);
		student.setGrade(grade);
		student.setRollNo(rollNo);
		student.setContactNo(contactNo);
		student.setGender(gender);
		student.setEmail(email);
		
		student.setHouseNo(houseNo);
		student.setStreet(street);
		student.setCity(city);
		student.setState(state);
		student.setPostalCode(postalCode);
    	
    	
		try {
			//here i get student id from db which i needed to show on studentDetails .jsp page
			int studentId = studentDao.selectSid(student);			
			//here id is given by db and not enetred by user,,so use attribute and not parameter
			request.setAttribute("studentId",studentId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/studentDetails").forward(request, response)	;
		
    	
   	}
    		
    		
}

	


