package com.hanium.searlution.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hanium.searlution.mapper.UserMapper;
import com.hanium.searlution.model.User;


@Component
public class UserDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(User user)
	{
		String sql = "INSERT INTO user_info(user_name, user_nickname, user_email, user_pw, user_phone) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getUser_name(), user.getUser_nickname(), user.getUser_email(),user.getUser_pw(),user.getUser_phone());
	}
	
	// 유저 조회 메서드 - 다수
	public List<User> select()
	{
		 String sql = "select * from user_info";
		 List<User> users = jdbcTemplate.query(sql, new UserMapper());
		 return users;
	}
	// 유저조회 메서드 - 단건(유저 번호 이용시)
	public User select(Integer user_no)
	{
		 String sql = "select * from user_info where user_no=?";
		 User user = jdbcTemplate.queryForObject(sql, new Object[] {user_no}, new UserMapper());
		 return user;
	}
	// 유저조회 메서드 - 단건(유저 이메일 이용 시)
	public User select(String user_email)
	{
		String sql = "select * from user_info where user_email=?";
		try
		{
			User user = jdbcTemplate.queryForObject(sql, new Object[] {user_email}, new UserMapper());
			return user;
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		
	}
	public void update(Integer user_no, User user)
	{
		String sql = "update user_info set user_nickname=?, user_phone=? where user_no =?";
		jdbcTemplate.update(sql, user.getUser_nickname(), user.getUser_phone(), user_no);
	}
	
	// 트렌젝션 처리가 필요할 경우 사용
	@Transactional
	public void sampleTransaction(User student) 
	{
	}
}
