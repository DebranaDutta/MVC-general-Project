<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="webapp/search_student.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="search">
		<h1>Enter Registration ID</h1>
		<form action="search" method="get">
		<table>
		<tr>
			<td><input type="text" name="student_id" placeholder="Sudent ID" required="required"/></td>
      		<td><button type="submit" class="btn btn-primary btn-block btn-large">Get Details</button></td>
      	</tr>
      	</table>
		</form>
	</div>
</body>
</html>