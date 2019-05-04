package com.segmentfault.springbootlesson1.minapp.demo;

import com.segmentfault.springbootlesson1.minapp.demo.pojo.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo
 * @Author: adminxt
 * @CreateTime: 2019-05-03 21:34
 * @Description: 微信小程序的CMS内容管理接口测试
 */
@RestController
@RequestMapping("/cms")
public class CmsController {

    private Logger logger = LoggerFactory.getLogger(CmsController.class);

    /**
     * 获取CMS内容列表页
     * @return
     */
    @RequestMapping("/getList")
    public List<News> getList(@RequestParam(defaultValue = "0") String lastid,
                              @RequestParam(defaultValue = "2") String limit){
        if(null == lastid || "".equals(lastid) || null == limit || "".equals(limit)){
            return null;
        }
        List<News> news = initNews();
        Integer lastId = null;
        Integer limitNum = null;
        try{
            lastId = Integer.parseInt(lastid);
            limitNum = Integer.parseInt(limit);
        }catch (Exception e){
            logger.info("获取CMS内容管理列表页，数据类型转换异常"+e.getCause());
        }
        List<News> newsList = null;
        if(null != lastId && null != limitNum && news.size() >= lastId){
            newsList = new ArrayList<>();
            // 根据传递来的下标先删除之前的数据
            for(int i = 1; i < lastId; i++){
               news.remove(i);
            }
            // 获取新的条数
            for(int i = 0; i < limitNum; i++){
                News news1 = news.get(i);
                newsList.add(news1);
            }
        }
        return newsList;
    }

    /**
     * 获取CMS内容详情页
     * @param id
     * @return
     */
    @RequestMapping("/getDetail")
    public News getDetail(String id){
        if(null == id || "".equals(id)){
            return null;
        }
        List<News> news = initNews();
        int num = 0;
        try {
            num = Integer.parseInt(id) - 1;
        }catch (Exception e){
            logger.info("获取CMS内容管理详情页，数据类型转换异常"+e.getCause());
        }
        return news.get(num);
    }

    private List<News> initNews(){
        List<News> list = new ArrayList<>();
        News news1 = new News(1,  "aaaa",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥1");
        list.add(news1);
        News news2 = new News(2,  "bbbb",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥2");
        list.add(news2);
        News news3 = new News(3,  "cccc",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥3");
        list.add(news3);
        News news4 = new News(4,  "dddd",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥4");
        list.add(news4);
        News news5 = new News(5,  "eeee",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥5");
        list.add(news5);
        News news6 = new News(6,  "ffff",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥6");
        list.add(news6);
        News news7 = new News(7,  "gggg",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥7");
        list.add(news7);
        News news8 = new News(8,  "mmmm",  "../../images/bj.jpg",  new Date(),  "你猜我写了啥8");
        list.add(news8);
        News news9 = new News(9,  "nnnn",  "../../images/bj.jpg", new Date(),  "你猜我写了啥9");
        list.add(news9);
        return list;
    }

    /**
     * 时间格式化
     * @param date 传入时间
     * @return 返回格式化的时间 yyyy-MM-dd HH:mm:ss
     */
    private String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
