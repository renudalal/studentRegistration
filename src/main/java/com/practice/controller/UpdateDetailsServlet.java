package com.practice.controller;
import java.io.IOException;
import java.sql.SQLException;

import com.practice.dao.StudentDao;
import com.practice.entities.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao = new StudentDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Student student = null;
		//this id is coming from jsp page
		int id =Integer.parseInt(request.getParameter("id"));
		try {
			student = studentDao.getStudentDetails(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("student", student);
		request.getRequestDispatcher("/updateDetails.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");//this field in bracket comes from jsp file
    	System.out.println("firstName"+firstName);
    	String lastName = request.getParameter("lastName");
    	String guardianName = request.getParameter("guardianname");
    	String dob = request.getParameter("dob");
    	int grade = Integer.parseInt(request.getParameter("grade"));
    	int rollNo = Integer.parseInt(request.getParameter("rollNo"));
    	int contactNo = Integer.parseInt(request.getParameter("contact"));
    	int gender = Integer.parseInt(request.getParameter("gender"));
    	String email = request.getParameter("email");
    	
    	int houseNo = Integer.parseInt(request.getParameter("houseNo"));
    	String street = request.getParameter("street");
    	String city = request.getParameter("city");//this field in bracket comes from jsp file    	
    	String state = request.getParameter("state");
    	String postalCode = request.getParameter("postalCode");
    	
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
			studentDao.updateDetails(id,student);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/updateMsg.jsp").forward(request, response)	;
		
    	
   	}
    		
    		
	}

