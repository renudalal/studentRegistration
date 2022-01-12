package com.practice.controller;

import java.io.IOException;
import java.sql.SQLException;
import com.practice.dao.StudentDao;
import com.practice.entities.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(value={"/studentDetails"})
public class StudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 3653423339724709644L;
	
	private StudentDao studentDao = new StudentDao();
	//constructor with super()is called by jvm by default
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Student student = null;
		//here this studentId is coming from studentServlet
		if(request.getAttribute("studentId") == null) {
			//parameter is used when user enters any inputc
			int studentId =  Integer.parseInt(request.getParameter("studentId"));
			try {
				student = studentDao.getStudentDetails(studentId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		else
			{
			int studentId =  (Integer) request.getAttribute("studentId");
			
			
			try {
				student = studentDao.getStudentDetails(studentId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		 
		request.setAttribute("student", student);		
		request.getRequestDispatcher("/studentDetails.jsp").forward(request, response);
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		   	
    	doGet(request, response);

	}
}