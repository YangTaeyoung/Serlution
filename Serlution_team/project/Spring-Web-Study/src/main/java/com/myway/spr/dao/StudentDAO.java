package com.myway.spr.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myway.spr.mapper.StudentMapper;
import com.myway.spr.model.Student;


@Component
public class StudentDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(Student student)
	{
		String sql = "INSERT INTO Student(id, name, age) VALUES(?,?,?)";
		jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge());
	}
	
	public List<Student> select()
	{
		 String sql = "select * from student";
		 List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
		 System.out.println("student >>> dao >>> " + students);
		 return students;
	}
	// 학생조회 메서드 - 단건
	public Student select(Integer seq)
	{
		 String sql = "select * from student where seq = ?";
		 Student student = jdbcTemplate.queryForObject(sql, new Object[] {seq}, new StudentMapper());
		 return student;
	}
	public void update(Student student)
	{
		String sql = "INSERT INTO Student_Bad(id, name, age) VALUES(?,?,?)";
		jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge());
		
	}
	
	// 학생 입력 후 에러가 발생하는 학생 수정을 호출하는 상황
	@Transactional
	public void sampleTransaction(Student student)
	{
		this.create(student);
		this.update(student);
	}
}
