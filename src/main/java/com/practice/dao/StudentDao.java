package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement ;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.practice.entities.Student;
import com.practice.utility.Connect_db;

public class StudentDao {

	Connection conn = null;
    PreparedStatement stmt = null;
    
  public Map<Integer, String> registerStudent(){	 
	Map<Integer,String> genderTypeList = new HashMap<>();	
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db?useSSL=false", "root", "root");
			java.sql.Statement statement=conn.createStatement();
			String sql ="SELECT genderId,genderType FROM gender";			
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				genderTypeList.put(resultSet.getInt(1),resultSet.getString(2));
			 }
		} catch (Exception e) {
			e.printStackTrace();
			}		
		return genderTypeList;
}
  
  private void insertStudentData(Student student) throws SQLException {	  
	  try{ 
		  String sql ="INSERT into student(firstName,lastName,guardianName,dob,grade,rollNo,contactNo,email,genderId)values(?,?,?,?,?,?,?,?,?);";		
		  conn = Connect_db.getConnection();
		  stmt=	 conn.prepareStatement(sql);
		  stmt.setString(1,student.getFirstName());
		  stmt.setString(2,student.getLastName());
		  stmt.setString(3,student.getGuardianName());
		  stmt.setString(4,student.getDob());
		  stmt.setInt(5,student.getGrade());
		  stmt.setInt(6,student.getRollNo());
		  stmt.setInt(7,student.getContactNo());
		  stmt.setString(8,student.getEmail());
		  stmt.setInt(9,student.getGender());
		  stmt.executeUpdate();					  
		} catch (Exception e) {
			e.printStackTrace();		 
	 }
	}
  
  //yha sy latest inserted id mil rhi h db sy
  public int selectSid(Student student) throws SQLException {//student is passed as parameter for readability,else i had to enter all values fn,ln,dob..as parameter to get value from jsp page to here
	  insertStudentData(student);
	  //selecting id from database and passing it to jsp page
	  int id =0;
	  String studentIdQuery ="SELECT studentId from Student where firstName=? and lastName=? and guardianName=? and dob=? and grade=? and rollNo=? and contactNo=? and email=? and genderId=?;";
	  conn = Connect_db.getConnection();
		stmt=  conn.prepareStatement(studentIdQuery);
		stmt.setString(1,student.getFirstName());
		stmt.setString(2,student.getLastName());
		stmt.setString(3,student.getGuardianName());
		stmt.setString(4,student.getDob());
		stmt.setInt(5,student.getGrade());
		stmt.setInt(6,student.getRollNo());
		stmt.setInt(7,student.getContactNo());
		stmt.setString(8,student.getEmail());
		stmt.setInt(9,student.getGender());			
		ResultSet resultSet = stmt.executeQuery();
		while(resultSet.next()){			
			id = resultSet.getInt(1);	
			}
		insertAddress(student,id);		
		return id;
}
  
  
  private void insertAddress(Student student,int id) throws SQLException {
	  String studentAddressQuery = "INSERT INTO Address(houseNo,street,city,state,postalCode,studentId)values(?,?,?,?,?,?);";
	  conn = Connect_db.getConnection();
	  stmt=  conn.prepareStatement(studentAddressQuery);
	  stmt.setInt(1,student.getHouseNo());
	  stmt.setString(2,student.getStreet());
	  stmt.setString(3,student.getCity());
	  stmt.setString(4,student.getState());
	  stmt.setString(5,student.getPostalCode());		
	  stmt.setInt(6,id);
	  stmt.executeUpdate();
  }
  
  public Student getStudentDetails(int studentId) throws SQLException{
		
	  Student student = null;
		String query = "Select * from student s,address a where s.studentId=a.studentId and s.studentId= " + studentId ;
		conn = Connect_db.getConnection();
		
		java.sql.Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
	        	String firstName =resultSet.getString(2);
	    		String lastName = resultSet.getString(3);
	    		String guardianName = resultSet.getString(4);
	    		String dob = resultSet.getString(5);
	    		int grade = resultSet.getInt(6);	    		
	    		int rollNo = resultSet.getInt(7);
	    		int contactNo = resultSet.getInt(8);
	    		String email = resultSet.getString(9);
	    		int gender = resultSet.getInt(10);
	    		
	    		int houseNo = resultSet.getInt(11);
	    		String street = resultSet.getString(12);
	    		String city = resultSet.getString(13);
	    		String state = resultSet.getString(14);
	    		String postalCode = resultSet.getString(15);
	    		student = new Student(studentId, firstName, lastName, guardianName, dob, grade, rollNo, contactNo, gender, email, houseNo,street , city, state, postalCode);
	    		}
			return student;
		
		}
  
  public void deleteStudentById(int id) throws SQLException{//ismy id StudentDeleteSevlet sy aaygi	  
	  System.out.println("inside delete student dao" + id);	  	  
	  String query = "Delete student,address from student INNER JOIN address  where student.studentId=address.studentId and student.studentId=" + id ;
	  conn = Connect_db.getConnection();
	  stmt = conn.prepareStatement(query);	  
	  stmt.executeUpdate();	  
	  	}
  
  
  public Student updateDetails(int id,Student student) throws SQLException {
	  conn = Connect_db.getConnection();
	  String query = "Update student,address set firstName=?,lastName=?,guardianName=?,dob=?,grade=?,rollNo=?,contactNo=?,email=?,houseNo=?,street=?,city=?,state=?,postalCode=? where student.studentId=address.studentId and student.studentId="+id;
	  stmt = conn.prepareStatement(query);

	  stmt.setString(1,student.getFirstName());
		stmt.setString(2,student.getLastName());
		stmt.setString(3,student.getGuardianName());
		stmt.setString(4,student.getDob());
		stmt.setInt(5,student.getGrade());
		stmt.setInt(6,student.getRollNo());
		stmt.setInt(7,student.getContactNo());
		stmt.setString(8,student.getEmail());
		stmt.setInt(9,student.getHouseNo());
		stmt.setString(10,student.getStreet());
		stmt.setString(11,student.getCity());
		stmt.setString(12,student.getState());
		stmt.setString(13,student.getPostalCode());	
		
		int rowsUpdated = stmt.executeUpdate();
		if (rowsUpdated > 0) {
			
		    System.out.println("An existing id was updated successfully!");
		}
	return student;
	}

  public ArrayList<Student> getAllDetails() throws SQLException {
	 
	  ArrayList<Student>studentList = new ArrayList<Student>();
	  conn = Connect_db.getConnection();
	  String query = "Select * from student;" ;
	  stmt = conn.prepareStatement(query);
	  ResultSet resultSet = stmt.executeQuery();
	  while(resultSet.next()){	
		  Student student= new Student();	
		  student.setId(resultSet.getInt(1));		
		  student.setFirstName(resultSet.getString(2));
		  student.setLastName(resultSet.getString(3));
		  studentList.add(student);
   		}	
	  System.out.println(studentList);
			
	  
	  return studentList;

	
}
}