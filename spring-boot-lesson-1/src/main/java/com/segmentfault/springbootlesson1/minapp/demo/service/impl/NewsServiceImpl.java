package com.segmentfault.springbootlesson1.minapp.demo.service.impl;

import com.segmentfault.springbootlesson1.minapp.demo.mapper.NewsMapper;
import com.segmentfault.springbootlesson1.minapp.demo.pojo.News;
import com.segmentfault.springbootlesson1.minapp.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.service
 * @Author: adminxt
 * @CreateTime: 2019-05-04 14:52
 * @Description: ${Description}
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getNewsList(Integer lastId, Integer limit) {
        return newsMapper.queryNewsList(lastId, limit);
    }

    @Override
    public News getNewsById(Integer id) {
        return newsMapper.queryNewsById(id);
    }
}
