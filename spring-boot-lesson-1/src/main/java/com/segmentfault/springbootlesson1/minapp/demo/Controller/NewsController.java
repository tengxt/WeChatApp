package com.segmentfault.springbootlesson1.minapp.demo.Controller;

import com.segmentfault.springbootlesson1.minapp.demo.pojo.News;
import com.segmentfault.springbootlesson1.minapp.demo.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo
 * @Author: adminxt
 * @CreateTime: 2019-05-04 10:57
 * @Description: 微信小程序后台内容管理接口
 */
@RestController
@RequestMapping("/minapp")
public class NewsController {

    private Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping("/query")
    public List<News> getList(@RequestParam(defaultValue = "0") String lastid,
                              @RequestParam(defaultValue = "2") String limit){
        if(null == lastid || "".equals(lastid) || null == limit || "".equals(limit)){
            return null;
        }
        Integer lastId = null;
        Integer limitNum = null;
        List<News> newsList = null;
        try{
            lastId = Integer.parseInt(lastid);
            limitNum = Integer.parseInt(limit);
            newsList = newsService.getNewsList(lastId, limitNum);
        }catch (Exception e){
            logger.info("获取CMS内容管理列表页，数据类型转换异常"+e.getCause());
        }
        return newsList;
    }

    @RequestMapping("/queryById")
    public News getById(String id){
        if(null == id || "".equals(id)){
            return null;
        }
        Integer strId = null;
        try{
            strId = Integer.parseInt(id);
        }catch (Exception e){
            logger.info("获取CMS内容管理详情页，数据类型转换异常"+e.getCause());
        }
        return newsService.getNewsById(strId);
    }

}
