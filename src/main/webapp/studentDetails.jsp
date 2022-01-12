<%@ include file="common/navigation.jspf" %>
<body>
<table>
	   
	   <tr>
		   <td style="color:gray;">
		  	 Student Id: <span style="color: #B13100;">${student.id}</span>
		      <br><br>
		     First Name: <span style="color: #B13100;">${student.firstName}</span>
		      <br><br>			    
			 Last Name <span style="color: #B13100;">${student.lastName}</span>
			 <br><br>
			 Guardian Name: <span style="color: #B13100;">${student.guardianName}</span>
			 <br><br>
			 DOB: <span style="color: #B13100;">${student.dob}</span>
			 <br><br>
			 Grade: <span style="color: #B13100;">${student.grade}</span>
		      <br><br>			    
			 Gender:<span style="color: #B13100;">${student.gender}</span>
			 <br><br>
			 Roll No: <span style="color: #B13100;">${student.rollNo}</span>
			 <br><br>
			 Contact: <span style="color: #B13100;">${student.contactNo}</span>
			 <br><br>
			 Email: <span style="color: #B13100;">${student.email}</span>
			 <br><br>
			 HouseNo: <span style="color: #B13100;">${student.houseNo}</span>
		      <br><br>			    
			 Street:<span style="color: #B13100;">${student.street}</span>
			 <br><br>
			 City: <span style="color: #B13100;">${student.city}</span>
			 <br><br>
			 State: <span style="color: #B13100;">${student.state}</span>
			 <br><br>
			 Postal Code: <span style="color: #B13100;">${student.postalCode}</span>
			 <br><br>
			 
		   </td>
		  </tr>
		<tr>
        		<td>&nbsp;</td>
        		<td><a href="${pageContext.request.contextPath}/register">Insert</a> 
        		<a href="${pageContext.request.contextPath}/delete?id=${student.id}">Delete</a>
        		<a href="<%=request.getContextPath()%>/update?id=${student.id}">Update</a></td>
        	</tr>
  		 
	  
	   
	</table>
	
</body>
</html>