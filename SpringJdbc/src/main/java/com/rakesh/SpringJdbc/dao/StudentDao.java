package com.rakesh.SpringJdbc.dao;

import java.util.List;

import com.rakesh.SpringJdbc.model.Student;

public interface StudentDao {
	public int insert(Student s);
	public int update(Student s);
	public int delete(int id);
	public Student getStudent(int id);
	public List<Student> getAllStudents();
}
