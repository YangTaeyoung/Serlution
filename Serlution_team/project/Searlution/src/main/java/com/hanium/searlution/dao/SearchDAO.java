package com.hanium.searlution.dao;

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
	// 검색 리스트 조회 - 전체
	public List<Search> select()
	{
		String sql = "select * from search_info";
		List<Search> searches = jdbcTemplate.query(sql, new SearchMapper());
		 
		return searches;
	}
	// 검색 리스트 조회 - 단건
	public Search select(int ser_no)
	{
		String sql = "select * from search_info where ser_no = ?";
		Search search = jdbcTemplate.queryForObject(sql, new Object[] {ser_no}, new SearchMapper());
		
		return search;
	}
	
	// 검색 리스트 삽입 - 단건
	public void insert(Search search)
	{
		String sql = "insert into search_info(ser_title, ser_content, ser_link, ser_date) values(?,?,?,NOW())";
		jdbcTemplate.update(sql,search.getSer_title(),search.getSer_content(),search.getSer_link());
	}
	
	// 검색 리스트 삽입 - 여러건
	public void insert(List<Search>searches)
	{
		for(int i = 0; i < searches.size(); i++)
		{
			insert(searches.get(i));
		}
	}
	
}
