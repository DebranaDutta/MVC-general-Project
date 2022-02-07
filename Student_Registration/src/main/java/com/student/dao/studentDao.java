package com.student.dao;

import com.student.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class studentDao 
{
	String url="jdbc:mysql://localhost:3306/students";
	String uname="root";
	String pwd="Debrana@95";
	
	String insert_student="insert into student values(?,?,?);";
	String search_student="select * from student where student_id=?;";
	String student_list="select * from student;";
	String student_delete="Delete from student where student_id=?;";
	String student_Update="update student set student_name=?,student_subject=? where student_id=?;";
	
	public student updateStudent(student std)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement preparedStatement=con.prepareStatement(student_Update);
	
			preparedStatement.setString(1, std.getStudent_name());
			preparedStatement.setString(2, std.getStudent_subject());
			preparedStatement.setInt(3, std.getStudent_id());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			con.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return std;		
	}
	
	public List<student> selectAllUser()
	{
		List<student> studentList=new ArrayList<>();
		student std=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement preparedStatement=con.prepareStatement(student_list);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int student_id=resultSet.getInt("student_id");
				String student_name=resultSet.getString("student_name");
				String student_subject=resultSet.getString("student_subject");
				std=new student(student_id,student_name,student_subject);
				studentList.add(std);
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return studentList;
	}
	
	public boolean deleteUser(int student_id) throws Exception
	{
		boolean rowdeleted=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection  connection=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement preparedStatement=connection.prepareStatement(student_delete);
			preparedStatement.setInt(1, student_id);
			rowdeleted=preparedStatement.executeUpdate()>0;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return rowdeleted;
	}
	
	public student SearchStudent(int student_id) throws Exception
	{
		student std=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement preparedStatement=con.prepareStatement(search_student);
			preparedStatement.setInt(1, student_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String name=resultSet.getString("student_name");
				String subject=resultSet.getString("student_subject");
				std=new student(student_id,name,subject);
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return std;
	}
	
	public void InsertStudent(student std)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,uname,pwd);
		PreparedStatement preparedStatement=connection.prepareStatement(insert_student);
		preparedStatement.setInt(1, std.getStudent_id());
		preparedStatement.setString(2, std.getStudent_name());
		preparedStatement.setString(3, std.getStudent_subject());
		
		int count=preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
}
