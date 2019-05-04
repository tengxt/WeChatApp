package com.segmentfault.springbootlesson1;

import com.segmentfault.springbootlesson1.minapp.demo.mapper.NewsMapper;
import com.segmentfault.springbootlesson1.minapp.demo.pojo.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLesson1ApplicationTests {

	@Autowired
	private NewsMapper newsMapper;

	@Test
	public void contextLoads() {
		List<News> newsList = newsMapper.queryNewsList(2, 1);
		for (News news: newsList) {
			System.out.println(news.getTitle());
		}
	}

	@Test
	public void TestQueryNewsById(){
		News news = newsMapper.queryNewsById(2);
		System.out.println(news.getTitle());
	}

}
