<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
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
            <th>Student Address</th>
          </tr>
        </thead>
        <tbody>
          <tr align="center">
            <td>${existing_std.student_id}</td>
            <td>${existing_std.student_name}</td>
            <td>${existing_std.student_subject}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>