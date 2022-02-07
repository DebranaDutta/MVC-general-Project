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
	<div>
      <h1>Student Details</h1>
      <table border="3px" width="50%" align="center">
        <thead>
          <tr align="center">
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Student Subject</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="std" items="${studentList}">
          <tr align="center">
            <%-- <td><c:out value="${std.student_id}"/>
            	<form>
            		<button type="submit" style="background-color: red;">Delete</button>
            	</form>
            	<form>
            		<button type="submit" style="background-color: green;">Update</button>
            	</form>
            </td> --%>
            <td><c:out value="${std.student_id}"/></td>
            <td><c:out value="${std.student_name}"/></td>
            <td><c:out value="${std.student_subject}"/></td>
            <td><a href="show_edit_form?id=<c:out value='${std.student_id}'/>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<c:out value='${std.student_id}'/>">Delete</a></td>
          </tr>
        </c:forEach>  
        </tbody>
      </table>
    </div>
</body>
</html>