//detail.js
//获取应用实例
const app = getApp()
Page({
  data: {
    info: { 
        id: 1, 
        title: "aaaa", 
        author: "热心市民大G",
        image: "../../images/bj.jpg", 
        curTime: "2019-05-02 09:37", 
        desc: "你猜我写了啥1" 
      }
  },
  onLoad: function (options) {
    var that = this

    wx.request({
      url: 'https://minapp.ngrok.xiaomiqiu.cn/minapp/queryById',
      data: { id:options.id},
      header: {
        'content-type': 'application/json' // 默认值
      },
      success(res) {
        that.setData({
          // 绑定数据
          info: res.data
        })
      }
    })
  }
})
