package com.segmentfault.springbootlesson1.minapp.demo.service.impl;

import com.segmentfault.springbootlesson1.minapp.demo.mapper.FeedMapper;
import com.segmentfault.springbootlesson1.minapp.demo.pojo.Feed;
import com.segmentfault.springbootlesson1.minapp.demo.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.service.impl
 * @Author: adminxt
 * @CreateTime: 2019-05-04 21:15
 * @Description: 小程序用户反馈接口页面
 */
@Service
public class FeedServiceImpl implements FeedService{

    @Autowired
    private FeedMapper feedMapper;

    @Override
    public int addFeed(Feed feed) {
        // 补全pojo
        feed.setCreateDate(new Date());

        int res = feedMapper.addFeed(feed);
        if(res > 0)
            return res;
        else
            return 0;
    }
}
