package com.practice.entities;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String guardianName;
	private String dob;
	private int grade;
	
	private int rollNo;
	private int contactNo;
	private int gender;
	private String email;
	
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	
	public Student(int id,String firstName, String lastName, String guardianName, String dob, int grade,
			int rollNo, int contactNo, int gender, String email, int houseNo, String street, String city, String state,
			String postalCode) {
		this.id = id;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.guardianName = guardianName;
		this.dob = dob;
		this.grade = grade;
		this.rollNo = rollNo;
		this.contactNo = contactNo;
		this.email = email;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", guardianName="
				+ guardianName + ", dob=" + dob + ", grade=" + grade + ", rollNo=" + rollNo + ", contactNo=" + contactNo
				+ ", gender=" + gender + ", email=" + email + ", houseNo=" + houseNo + ", street=" + street + ", city="
				+ city + ", state=" + state + ", postalCode=" + postalCode + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
