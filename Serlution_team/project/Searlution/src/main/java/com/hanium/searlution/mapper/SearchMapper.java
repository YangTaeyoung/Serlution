package com.hanium.searlution.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hanium.searlution.model.Search;


public class SearchMapper implements RowMapper<Search>{

	@Override
	public Search mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Search search = new Search();
		search.setSer_no(rs.getInt("ser_no"));
		search.setSer_content(rs.getString("ser_content"));
		search.setSer_title(rs.getString("ser_title"));
		search.setSer_link(rs.getString("ser_link"));
		search.setSer_date(rs.getString("ser_date"));
		
		return search;
	}

	
}
