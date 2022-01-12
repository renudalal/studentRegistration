<%@ include file="common/navigation.jspf" %>
<body>
<form method = "POST" action ="<%=request.getContextPath()%>/update?id=${student.id}">
<table>
		   <tr>
        		<td><label>Student Id:</label></td>
        		<td>
        			<input type="text" name="studentId" value =${student.id} ><br>
        		</td>        
        	</tr>
		  	 	     
		      <tr>
        		<td><label> First Name:</label></td>
        		<td>
        			<input type="text" name="firstName" value =${student.firstName} ><br>
        		</td>        
        	</tr>
        	
        	<tr>
        		<td><label> Last Name</label></td>
        		<td>
        			<input type="text" name="lastName" value =${student.lastName} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label> Guardian Name</label></td>
        		<td>
        			<input type="text" name="guardianname" value =${student.guardianName} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>DOB</label></td>
        		<td>
        			<input type="date" name="dob" value =${student.dob}><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Grade</label></td>
        		<td>
        			<input type="text" name="grade" value =${student.grade}><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label> Gender</label></td>
        		<td>
        			<input type="text" name="gender" value =${student.gender}><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Roll No</label></td>
        		<td>
        			<input type="text" name="rollNo" value =${student.rollNo}><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Contact</label></td>
        		<td>
        			<input type="text" name="contact" value =${student.contactNo} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Email</label></td>
        		<td>
        			<input type="text" name="email" value =${student.email} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>HouseNo</label></td>
        		<td>
        			<input type="text" name="houseNo" value =${student.houseNo} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Street</label></td>
        		<td>
        			<input type="text" name="street" value =${student.street} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>City</label></td>
        		<td>
        			<input type="text" name="city" value =${student.city} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>State</label></td>
        		<td>
        			<input type="text" name="state" value =${student.state} ><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Postal Code</label></td>
        		<td>
        			<input type="text" name="postalCode" value =${student.postalCode} ><br>
        		</td>           		    
        	</tr>
        	<tr>
        		<td>&nbsp;</td>
        		<td><input type="submit" name="UpdateForm" value="Update"></td>
        	</tr>
   </table>    
   </form> 	
</body>
</html>