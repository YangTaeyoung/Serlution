package com.hanium.searlution.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hanium.searlution.model.WordCount;

public class WordCountMapper implements RowMapper<WordCount> {

	@Override
	public WordCount mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		WordCount wordCount = new WordCount();
		wordCount.setWord_name(rs.getString("word_name"));
		wordCount.setWord_Count(rs.getInt("word_count"));
		
		return wordCount;
	}
	
}
