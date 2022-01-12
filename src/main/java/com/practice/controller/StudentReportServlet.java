package com.practice.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import com.practice.dao.StudentDao;
import com.practice.entities.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentDao studentDao = new StudentDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> studentList = null;
		
		try {
			studentList = studentDao.getAllDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		request.setAttribute("studentList", studentList);		
		request.getRequestDispatcher("/studentReport.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
