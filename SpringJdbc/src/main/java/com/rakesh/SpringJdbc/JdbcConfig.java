package com.rakesh.SpringJdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.rakesh.SpringJdbc.dao.StudentDaoImp;

@Configuration
@ComponentScan(basePackages= {"com.rakesh.SpringJdbc.dao"})
public class JdbcConfig {
	
	@Bean("dataSource")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("Rakesh1234@#");
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
//	@Bean("studentDao")
//	public StudentDaoImp getStudentDao()
//	{
//		StudentDaoImp studentDao = new StudentDaoImp();
//		studentDao.setJdbcTemplate(getJdbcTemplate());
//		
//		return studentDao;
//	}
}
