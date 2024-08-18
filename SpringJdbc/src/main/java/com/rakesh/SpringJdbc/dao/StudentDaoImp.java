package com.rakesh.SpringJdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rakesh.SpringJdbc.model.Student;

@Component("studentDao")
public class StudentDaoImp implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student s)
	{
		String query ="Insert Into Student(id,name,address) Values (?,?,?)";
		int result = jdbcTemplate.update(query,s.getId(),s.getName(),s.getAddress());
		return result;
	}
	
	public int update(Student s)
	{
		String query = "Update Student Set name=?, address=? Where id=?";
		int result = jdbcTemplate.update(query,s.getName(),s.getAddress(),s.getId());
		return result;
	}
	
	public int delete(int id)
	{
		String query = "Delete From Student where id=?";
		int result = jdbcTemplate.update(query,id);
		return result;
	}
	
	public Student getStudent(int id)
	{
		String query = "Select * From Student Where id=?";
		RowMapper<Student> rowMapper = new RowMapperImp();
		Student s = jdbcTemplate.queryForObject(query,rowMapper,id);
		return s;
	}
	
	public List<Student> getAllStudents()
	{
		String query = "Select * From Student";
		RowMapper<Student> rowMapper = new RowMapperImp();
		List<Student> l = jdbcTemplate.query(query,rowMapper);
		return l;
	}
}
