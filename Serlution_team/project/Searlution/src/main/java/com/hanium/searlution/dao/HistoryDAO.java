package com.hanium.searlution.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hanium.searlution.mapper.HistoryMapper;
import com.hanium.searlution.model.History;

@Component
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
	public int getHistoryCount(int user_no, String history_key)
	{
		String sql = "select history_count where user_no = ? and history = ?";
		History history = jdbcTemplate.queryForObject(sql, new Object[]{user_no, history_key}, new HistoryMapper());
		return history.getHistory_count();
	}
	
	public int getHistory_no(int user_no, String history_key)
	{
		
		String sql = "select history_no from history_info where history_key = ? and user_no = ?";
		int history_no = jdbcTemplate.queryForInt(sql, history_key, user_no);
		return history_no;
	}
	
	public void insert(History history)
	{
		String sql = "insert into history_info(user_no, history_key, history_count, history_date) values(?,?,?,now())";
		jdbcTemplate.update(sql, history.getUser_no(), history.getHistory_key(), history.getHistory_count());
	}
	
	public void countUp(int history_no)
	{
		String sql = "update history_info set history_date=now(), history_count = history_count+1 where history_no = ?";
		jdbcTemplate.update(sql, history_no);
	}
	
	public void countUp(int user_no, String history_key)
	{
		countUp(getHistory_no(user_no, history_key));
	}
	
}
