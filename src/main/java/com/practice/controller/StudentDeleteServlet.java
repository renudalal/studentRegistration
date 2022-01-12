package com.practice.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.practice.dao.StudentDao;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(value={"/delete"})
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao = new StudentDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		try {
		 studentDao.deleteStudentById(id);
		} catch (SQLException e) {			
			e.printStackTrace();
	}
			request.getRequestDispatcher("/deleteMsg.jsp").forward(request, response);
	}
	
	
}
