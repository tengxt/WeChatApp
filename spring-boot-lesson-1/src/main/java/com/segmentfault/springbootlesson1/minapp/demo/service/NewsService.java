package com.segmentfault.springbootlesson1.minapp.demo.service;

import com.segmentfault.springbootlesson1.minapp.demo.pojo.News;

import java.util.List;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.service
 * @Author: adminxt
 * @CreateTime: 2019-05-04 14:50
 * @Description: ${Description}
 */
public interface NewsService {
    /**
     * 分页查询CMS内容数据
     * @param lastId
     * @param limit
     * @return
     */
    List<News> getNewsList(Integer lastId,Integer limit);

    /**
     * 根据编号查询内容详细信息
     * @param id
     * @return
     */
    News getNewsById(Integer id);
}
