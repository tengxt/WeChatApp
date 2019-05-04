package com.segmentfault.springbootlesson1.minapp.demo.pojo;

import java.util.Date;

/**
 * @BelongsProject: spring-boot-lesson-1
 * @BelongsPackage: com.segmentfault.springbootlesson1.minapp.demo
 * @Author: adminxt
 * @CreateTime: 2019-05-03 21:51
 * @Description: 文章列表页
 */
public class News {
    private Integer id;
    private String title;
    private String image;
    private Date curTime;
    private String desc;

    public News() {
    }

    public News(Integer id, String title, String image, Date curTime, String desc) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.curTime = curTime;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCurTime() {
        return curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
