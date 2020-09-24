package com.hanium.searlution.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hanium.searlution.model.History;

public class HistoryMapper implements RowMapper<History> {

	@Override
	public History mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		History history = new History();
		history.setHistory_no(rs.getInt("history_no"));
		history.setHistory_date(rs.getString("history_date"));
		history.setHistory_key(rs.getString("history_key"));
		history.setUser_no(rs.getInt("user_no"));
		
		return history;
	}
	
}
