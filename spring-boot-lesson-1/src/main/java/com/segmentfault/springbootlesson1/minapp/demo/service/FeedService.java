package com.segmentfault.springbootlesson1.minapp.demo.service;


import com.segmentfault.springbootlesson1.minapp.demo.pojo.Feed;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.service
 * @Author: adminxt
 * @CreateTime: 2019-05-04 21:13
 * @Description: 反馈信息
 */
public interface FeedService {

    int addFeed(Feed feed);
}
