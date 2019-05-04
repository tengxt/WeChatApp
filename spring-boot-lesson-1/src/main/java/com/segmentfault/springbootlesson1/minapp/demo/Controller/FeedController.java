package com.segmentfault.springbootlesson1.minapp.demo.Controller;

import com.segmentfault.springbootlesson1.minapp.demo.pojo.Feed;
import com.segmentfault.springbootlesson1.minapp.demo.service.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.Controller
 * @Author: adminxt
 * @CreateTime: 2019-05-04 21:18
 * @Description: 微信小程序后台用户反馈接口
 */
@RestController
@RequestMapping("/minapp")
public class FeedController {

    private Logger logger = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    private FeedService feedService;

    @RequestMapping("/addFeed")
    public Map<String,Object> addFeed(Feed feed){
        Map<String,Object> resultMap  = new HashMap<String, Object>();
        if(null == feed){
            resultMap.put("code",-1);
            resultMap.put("msg","提交失败，请稍后重试");
            return resultMap;
        }
        // 关注的产品 0:微商城 1：微社区 2：VLog
        String product = feed.getProduct();
        //去除中括号'['
        String newProduct = product.substring(1, product.length() - 1);
        // 分组
        String[] strArr = newProduct.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        String caseProduct = null;
        for(int i = 0 ; i < strArr.length; i++){
            String str = strArr[i];
            // 去除引号
            String s = str.substring(1, str.length() - 1);
            switch (s){
                case "0":
                    caseProduct = "微商城,";
                    break;
                case "1":
                    caseProduct = "微社区,";
                    break;
                case "2":
                    caseProduct = "VLog";
                    break;
            }
            stringBuilder.append(caseProduct);
        }
        feed.setProduct(stringBuilder.toString());
        // 来源 ： 0：Google 1：朋友圈 2:公总号
        // 所在地区： 0：美国 1：中国 2：巴西 3：日本
        // 是否是前端开发工程师 0：是 1：不是
        try{
            int res = feedService.addFeed(feed);
            if(0 < res){
                resultMap.put("code",0);
                resultMap.put("msg","提交成功");
                return resultMap;
            }
            resultMap.put("code",-1);
            resultMap.put("msg","提交失败，请稍后重试");
            return resultMap;
        }catch (Exception e){
            logger.info("添加用户反馈页面，SQL语句异常"+e.getCause());
            resultMap.put("code",-1);
            resultMap.put("msg","提交失败，请稍后重试");
            return resultMap;
        }
    }
}
