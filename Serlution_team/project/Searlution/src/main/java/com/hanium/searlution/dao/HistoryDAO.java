package com.hanium.searlution.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hanium.searlution.mapper.HistoryMapper;
import com.hanium.searlution.model.History;

public class HistoryDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public History select(int history_no)
	{
		String sql = "select * from history_info where history_no=?";
		History history = jdbcTemplate.queryForObject(sql, new Object[]{history_no}, new HistoryMapper());
		return history;
	}
	public List<History> select()
	{
		String sql = "select * from history_info";
		List<History> histories = jdbcTemplate.query(sql, new HistoryMapper());
		return histories;
	}
	public void insert()
	{
		String sql = "insert into history_info(user_no, history_key, history_count, history_date) values(?,?,?,now())";
		jdbcTemplate.update(sql);
	}
	
}
