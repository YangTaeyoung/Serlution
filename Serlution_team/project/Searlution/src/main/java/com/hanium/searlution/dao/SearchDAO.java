package com.hanium.searlution.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hanium.searlution.mapper.SearchMapper;
import com.hanium.searlution.model.Search;

@Component
public class SearchDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean isExist(String keyword)
	{
		System.out.println("isExist");
		String sql = "select count(*) from key_list where key_name = ?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {keyword.toLowerCase()},Integer.class);
		System.out.println("count: "+count);
		if(count > 0)
			return true;
		else
			return false;	
	}
	public void pushKey(String keyword)
	{
		String sql = "insert into key_list(key_name) values(?)";
		jdbcTemplate.update(sql, keyword.toLowerCase());
	}
	public void createTable(String tableName)
	{
		
		String sql = "CREATE TABLE " + tableName + "_key (ser_no INT PRIMARY KEY  AUTO_INCREMENT, ser_title TEXT, ser_content TEXT, ser_link TEXT, ser_date TEXT) CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";
		jdbcTemplate.execute(sql);
		pushKey(tableName);
	}
	
	// 검색 리스트 조회 - 전체
	public List<Search> select(String keyword)
	{
		String sql = "select * from " + keyword.toLowerCase()+"_key";
		List<Search> searches = jdbcTemplate.query(sql, new SearchMapper());
		 
		return searches;
	}
	// 검색 리스트 조회 - 단건
	public Search select(String keyword,int ser_no)
	{
		String sql = "select * from " + keyword.toLowerCase()+"_key" + " where ser_no = ?";
		Search search = jdbcTemplate.queryForObject(sql, new Object[] {ser_no}, new SearchMapper());
		
		return search;
	}
	
	// 검색 리스트 삽입 - 단건
	public void insert(String keyword, Search search)
	{		
		String sql = "insert into " + keyword.toLowerCase()+"_key" + " (ser_title, ser_content, ser_link, ser_date) values(?,?,?,?)";
		jdbcTemplate.update(sql, search.getSer_title(), search.getSer_content(), search.getSer_link(), search.getSer_date());
		
	}
	
	// 검색 리스트 삽입 - 여러건
	public void insert(String keyword, List<Search>searches)
	{
		for(int i = 0; i < searches.size(); i++)
		{
			insert(keyword, searches.get(i));
		}
	}
	
}
