package com.hanium.searlution.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hanium.searlution.mapper.WordCountMapper;
import com.hanium.searlution.model.Search;
import com.hanium.searlution.model.WordCount;

@Component
public class WordCountDAO {

	@Autowired
	SearchDAO searchDAO;
	@Autowired
	ServletContext servletContext;
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(WordCount wordCount, String keyword)
	{
		String sql = "insert into count_info(word_name, word_count, keyword) values(?,?,?)";
		jdbcTemplate.update(sql, wordCount.getWord_name(), wordCount.getWord_count(), keyword);	
	}
	public void insert(List<WordCount> wordCounts, String keyword)
	{
		for(int i = 0; i < wordCounts.size(); i++)
		{
			insert(wordCounts.get(i), keyword);
		}
	}
	public List<WordCount> select(String keyword)
	{
		String sql = "select word_name, word_count from count_info where keyword = '" + keyword+"'";
		List<WordCount> wordCounts = jdbcTemplate.query(sql, new WordCountMapper());
		return wordCounts;
	}
	public List<WordCount> selectByRank(String keyword)
	{
		String sql = "select word_name, word_count from count_info where keyword = '" + keyword+"' order by word_count desc limit 20"; // 상위 카운트 20개 레코드 가져오기
		List<WordCount> wordCounts = jdbcTemplate.query(sql, new WordCountMapper());
		return wordCounts;
	}
}
