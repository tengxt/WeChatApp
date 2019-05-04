# WeChatApp
微信小程序之CMS内容开发
1.以SpringBoot作为给小程序提供数据接口（MyBatis）

## spring-boot-lesson-1
后台管理的目录，以IDEA搭建的SpringBoot2.0的应用

## test-01
微信小程序页面，原生实现

## minapp.sql
数据库文件

### 微信小程序

Demo <https://github.com/wechat-miniprogram/miniprogram-demo>

#### 1、微信小程序，新建页面后在`app.json`中配置页面后，发生日下的错误。

![20190320102137815.png](https://i.loli.net/2019/05/05/5ccdbf7a16c73.png)

解决办法： 在目标文件下的`.js`文件中添加 `Page()`方法。

```js
Page({
  data: {
  }
})
```



#### 2、微信小程序本地测试时，用localhost链接报错如下

已经关闭域名的校验的前提下。

关闭域名的校验的步骤：

?	微信开发者工具-----》设置-------》项目设置-------》不校验合法域名、web-view（业务域名）、TLS版本以及HTTPS证书。

![TIM截图20190504005446.png](https://i.loli.net/2019/05/05/5ccdbfd026572.png)

如果本地测试的话，建议使用`ngrok`内网穿透工具，解析成域名进行访问。

> 参考链接：<http://ngrok.ciqiuwl.cn/>
