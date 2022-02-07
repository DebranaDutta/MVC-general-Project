<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Student Form</h1>
	<form action="edit" method="get">
		<table>
			<tr>
				<td><input type="text" name="student_id" value="${edit_existing_student.student_id}"/></td>
				<td><input type="text" name="student_name" value="${edit_existing_student.student_name}"/></td>
				<td><input type="text" name="student_subject" value="${edit_existing_student.student_subject}"/></td>
				<td><button type="button">Submit</button></td>
			</tr>
		</table>	
	</form>
</body>
</html>