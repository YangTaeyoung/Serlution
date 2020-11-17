package com.hanium.searlution.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hanium.searlution.mapper.SearchMapper;
import com.hanium.searlution.model.Search;
import com.hanium.searlution.model.WordCount;

@Component
public class SearchDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean isExist(String keyword) // db에 해당 키워드로 검색 이력이 있는지 없는지 검사.
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
//	public void createTable(String tableName) // 삭제
//	{
//		
//		String sql = "CREATE TABLE " + tableName + "_key (ser_no INT PRIMARY KEY  AUTO_INCREMENT, ser_title TEXT, ser_content TEXT, ser_link TEXT, ser_date TEXT) CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";
//		jdbcTemplate.execute(sql);
//		pushKey(tableName);
//	}
	
	// 검색 리스트 조회 - 전체
	public List<Search> select(String keyword)
	{
		String sql = "select * from search_info where keyword='"+keyword+"'";
		List<Search> searches = jdbcTemplate.query(sql, new SearchMapper());
		 
		return searches;
	}
	// 검색 리스트 조회 - 단건
	public Search select(String keyword,int ser_no)
	{
		String sql = "select * from  search_info where keyword=? and ser_no = ?";
		Search search = jdbcTemplate.queryForObject(sql, new Object[] {keyword, ser_no}, new SearchMapper());
		
		return search;
	}
	
	// 검색 리스트 삽입 - 단건
	public void insert(String keyword, Search search)
	{		
		String sql = "insert into search_info (ser_title, ser_content, ser_link, ser_date, keyword) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, search.getSer_title(), search.getSer_content(), search.getSer_link(), search.getSer_date(),keyword);
		
	}
	
	// 검색 리스트 삽입 - 여러건
	public void insert(String keyword, List<Search>searches)
	{
		for(int i = 0; i < searches.size(); i++)
		{
			insert(keyword, searches.get(i));
		}
	}
	public void saveFile(String keyword)
	{
		List<Search> searches = select(keyword);

		try // 파일 예외처리.
		{
			System.out.println(servletContext.getRealPath("/resources/wordCount/") + keyword+"_key.txt");
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
