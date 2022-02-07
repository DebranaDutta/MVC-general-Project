package com.student.model;

public class student 
{
	private int student_id;
	private String student_name;
	private String student_subject;
	
	
	
	public student(int student_id) {
		super();
		this.student_id = student_id;
	}

	public student(int student_id, String student_name, String student_subject) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_subject = student_subject;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_subject() {
		return student_subject;
	}

	public void setStudent_subject(String student_subject) {
		this.student_subject = student_subject;
	}
	
	
}
