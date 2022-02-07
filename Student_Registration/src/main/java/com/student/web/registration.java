package com.student.web;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.studentDao;
import com.student.model.student;

@WebServlet("/")
public class registration extends HttpServlet
{
	public studentDao stDao=new studentDao();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String action=request.getServletPath();
		try 
		{
			switch (action) 
			{
				case "/registration": 
					insertUser(request, response);
					break;
				case "/search":
					search_Student(request,response);
					break;
				case "/view":
					student_List(request, response);
				case "/delete":
					deleteStudent(request, response);
				case "/show_edit_form":
					show_edit_form(request,response);
				case "/edit":	
					edit_student(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void edit_student(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException,ServletException
	{
		String student_name=request.getParameter("student_name");
		String student_subject=request.getParameter("student_subject");
		int  student_id=Integer.parseInt(request.getParameter("student_id"));
		
		System.out.println(student_id+" "+student_name+" "+student_subject);
		try
		{
			student student=new student(student_id, student_name, student_subject);
			stDao.updateStudent(student);
			student_List(request, response);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	private void insertUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException
	{
		int student_id=Integer.parseInt(request.getParameter("student_id"));
		String student_name=request.getParameter("student_name");
		String student_subject=request.getParameter("student_subject");
		
		student std=new student(student_id, student_name, student_subject);
		
		try 
		{
			stDao.InsertStudent(std);
			student_List(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void show_edit_form(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException, ServletException
	{
		
		int student_id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(student_id);
		try
		{
			student edit_existing_student=stDao.SearchStudent(student_id);
			System.out.println(edit_existing_student.getStudent_id()+" "+edit_existing_student.getStudent_name()+" "+edit_existing_student.getStudent_subject());
			request.setAttribute("edit_existing_student", edit_existing_student);
			RequestDispatcher dispatcher=request.getRequestDispatcher("edit_student.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	private void search_Student(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException
	{
		int student_id=Integer.parseInt(request.getParameter("student_id"));
		try 
		{
			student existing_std=stDao.SearchStudent(student_id);
			request.setAttribute("existing_std", existing_std);
			RequestDispatcher dispatcher=request.getRequestDispatcher("search_information.jsp");
			dispatcher.forward(request, response);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	private void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		int studen_id=Integer.parseInt(request.getParameter("id"));
		stDao.deleteUser(studen_id);
		student_List(request, response);
	}
	
	
	
	private void student_List(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException,ServletException
	{
		List<student> studentList=stDao.selectAllUser();
		for(student std:studentList)
		{
			System.out.println(std.getStudent_id()+" "+std.getStudent_name()+" "+std.getStudent_subject());
		}
		request.setAttribute("studentList",studentList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("show_student.jsp");
		requestDispatcher.forward(request, response);
	}

	
	
	/*
	 * protected void doPost(HttpServletRequest request,HttpServletResponse
	 * response) throws IOException,ServletException { String
	 * action=request.getServletPath(); try { switch (action) { case
	 * "/registration": insertUser(request, response); break; case "/search":
	 * search_Student(request,response); break; case "/view": student_List(request,
	 * response); case "/delete": deleteStudent(request, response); } }
	 * catch(Exception e) { System.out.println(e); } }
	 */
}
