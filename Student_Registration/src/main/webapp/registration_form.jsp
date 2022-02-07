<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1" />
    <title>Student Registration Form</title>
  </head>
  <body>
    <div class="login">
      <h1>Student registration form</h1>
      <form action="registration" method="get">
      <table>
      <tr>
        <td><input type="text" name="student_id" placeholder="Student ID" required="required"/></td>
        <td><input type="text" name="student_name" placeholder="Student Name" required="required"/></td>
        <td><input type="text" name="student_subject" placeholder="Student Subject" required="required"/></td> 
      	<td><button type="submit" class="btn btn-primary btn-block btn-large"> Register</button></td>
      </tr>  
      </table>
      </form>
    </div>
  </body>
</html>
