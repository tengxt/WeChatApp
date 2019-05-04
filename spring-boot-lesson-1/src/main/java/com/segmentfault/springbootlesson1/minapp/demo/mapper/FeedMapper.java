package com.segmentfault.springbootlesson1.minapp.demo.mapper;

import com.segmentfault.springbootlesson1.minapp.demo.pojo.Feed;
import org.apache.ibatis.annotations.Insert;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.mapper
 * @Author: adminxt
 * @CreateTime: 2019-05-04 21:09
 * @Description: ${Description}
 */
public interface FeedMapper {

    @Insert("INSERT INTO feed(username,product,source,area,score,isFront,createDate) VALUES" +
            "(#{username},#{product},#{source},#{area},#{score},#{isFront},#{createDate})")
    int addFeed(Feed feed);
}
