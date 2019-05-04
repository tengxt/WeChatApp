package com.segmentfault.springbootlesson1.minapp.demo.mapper;

import com.segmentfault.springbootlesson1.minapp.demo.pojo.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo.mapper
 * @Author: adminxt
 * @CreateTime: 2019-05-04 14:16
 * @Description: ${Description}
 */

public interface NewsMapper {

    @Select("SELECT * FROM news  LIMIT #{lastId},#{limit}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "image", column = "image"),
            @Result(property = "curTime", column = "curTime"),
            @Result(property = "desc", column = "desc")
    })
    List<News> queryNewsList(@Param("lastId") Integer lastId, @Param("limit") Integer limit);

    @Select("SELECT * FROM news WHERE id=#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "image", column = "image"),
            @Result(property = "curTime", column = "curTime"),
            @Result(property = "desc", column = "desc")
    })
    News queryNewsById(Integer id);
}
