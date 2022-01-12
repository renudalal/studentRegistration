<%@ include file="common/navigation.jspf" %>
<body>
	
 <form method = "POST" action ="<%=request.getContextPath()%>/register">   

	    <table>
	    
	    	 <tr>
	    		<td><label>First Name:</label></td>
        		<td>
        			<input type="text" name="fname"><br>        			
        		</td>
        		
        		<td><label>Last Name:</label></td>
        		<td>
         			<input type="text" name="lname"><br>        			
        		</td>
        	</tr>
        	
        	
        	
        	<tr>
        		<td><label>Guardian Name:</label></td>
        		<td>
        			<input type="text" name="guardianname"><br>
        		</td>        
        	</tr>
        	
        	<tr>
        		<td><label>DOB:</label></td>
        		<td>
        			<input type="date" name="dob"><br>
        		</td>        
        	</tr>
        	
        	<tr>
        		<td><label>Grade:</label></td>
        		<td>
        			<input type="text" name="grade"><br>
        		</td>        
        	</tr>
        	
        	<tr>
        	<td>Gender:</td>
        	 <td> 
	   		 <select  name= "selectGender">
        	 <c:forEach var="row" items="${genderTypeList}" ><!-- for each item in List<String>genderType print the value gender,  -->
        	 
        	 <option value = "${row.key}">${row.value}</option>
        	 
        	  
			</c:forEach></select>
			</tr>
        	
        	<tr>
        		<td><label>Roll No:</label></td>
        		<td>
        			<input type="text" name="rollno"><br>
        		</td>        
        	</tr>
        	
        	<tr>
        		<td><label>Address:</label></td>
        		<td>
        			<input type="text" placeholder = "House No." name="hno"><br>
        		</td>
        		<td>
        			<input type="text" placeholder = "Street" name="street"><br>
        		</td>     
        		<td>
        			<input type="text" placeholder = "City" name="city"><br>
        		</td>   
        		<td>
        			<input type="text" placeholder = "State" name="state"><br>
        		</td> 
        		<td>
        			<input type="text" placeholder = "Postal code" name="pcode" />
        		</td>  
        	</tr>
        	
        	<tr>
        		<td><label>Contact:</label></td>
        		<td>
        			<input type="text" name="contact"><br>
        		</td>        
        	</tr>
        	<tr>
        		<td><label>Email:</label></td>
        		<td>
        			<input type="text" name="email"><br>
        		</td>        
        	</tr>
        	<tr>
        		<td>&nbsp;</td>
        		<td><input type="submit" name="submitForm" value="Submit"></td>
        	</tr>
        	
        </table>
        	

 
</form>

</body>
</html>
