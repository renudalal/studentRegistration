<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

		<tr><th><b>S.Id</b></th>
		<!-- <th>FirstName</th>
		<th>LastName</th></tr> -->

    <c:forEach var="student" items="${studentList}">
        <tr>  
       
          <td><a href="<%=request.getContextPath()%>/studentDetails?studentId=${student.id}">${student.id}</a></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
          
           <td>${student.firstName}</td><td>&nbsp;</td>
           <td>${student.lastName}</td><td>&nbsp;</td>
           <td><a href="<%=request.getContextPath()%>/delete?id=${student.id}">Delete</a></td><td>&nbsp;</td>
        	<td><a href="<%=request.getContextPath()%>/update?id=${student.id}">Update</a></td>
           
        </tr>
    </c:forEach>
</table>

</body>
</html>