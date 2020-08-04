package com.hanium.searlution.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hanium.searlution.model.User;


public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUser_no(rs.getInt("user_no"));
		user.setUser_email(rs.getString("user_email"));
		user.setUser_name(rs.getString("user_name"));
		user.setUser_phone(rs.getString("user_phone"));
		user.setUser_nickname(rs.getString("user_nickname"));
		user.setUser_pw(rs.getString("user_pw"));
		return user;
	}

}

