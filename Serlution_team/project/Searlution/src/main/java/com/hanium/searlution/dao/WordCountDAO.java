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
	public void saveFile(String keyword)
	{
		List<Search> searches = searchDAO.select(keyword);
		
		List<WordCount> wordCounts;
		
		try // 파일 예외처리.
		{
			OutputStream os = new FileOutputStream(servletContext.getRealPath("/resources/wordCount/") + keyword+"_key.txt"); // resource\wordCount 폴더에 검색한 단어_key.txt파일로 저장 제목, 내용의 연속
			byte[] by; // 바이트 형 배열형성
			for(int i = 0; i < searches.size(); i++)
			{
				by = searches.get(i).getSer_title().getBytes(); // 받아온 객채 내의 제목 스트링을 바이트 형식으로 변환. txt파일에 쓰려면 바이트 형식이어야 하므로.
				os.write(by); // 제목 저장
				by = searches.get(i).getSer_content().getBytes(); // 내용 스트링을 바이트 형식으로 변환
				os.write(by); // 내용 저장
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
