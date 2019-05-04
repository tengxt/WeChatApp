//form.js
//获取应用实例
const app = getApp()

Page({
  data: {
    array: ['美国', '中国', '巴西', '日本'],
    area: 0,
    score: 0,
    isFront: 0
  },
  bindPickerChange: function(e){
    //console.log('form发生了bindPickerChange事件，携带数据为：', e.detail.value)
    this.setData({ area: e.detail.value})
  },
  bindSliderChange: function (e) {
    //console.log('form发生了bindSliderChange事件，携带数据为：', e.detail.value)
    this.setData({ score: e.detail.value })
  },
  bindSwitchChange: function (e) {
    console.log('form发生了bindSwitchChange事件，携带数据为：', e.detail.value)
    this.setData({ score: e.detail.value })
  },
  formSubmit(e) {
    //console.log('form发生了submit事件，携带数据为：', e.detail.value)
    var formData = e.detail.value
    formData.area = this.data.area
    formData.score = this.data.score
    formData.isFront = this.data.isFront
    console.log('form发生了事件，携带数据为：', formData)

    var that = this

    // 显示数据加载中的提示
    wx.showLoading({
      title: '提交中...',
    })

    wx.request({
      url: 'https://minapp.ngrok.xiaomiqiu.cn/minapp/addFeed',
      data: formData,
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        if(res.data.code==0){
          wx.showToast({
            title: res.data.msg,
            icon: 'success',
            duration: 3000
          })
        }else{
          wx.showToast({
            title: '提交失败，请稍后重试',
            icon: 'fail',
            duration: 3000
          })
        }
      },
      complete: function () {
        // 隐藏数据加载中的提示
        wx.hideLoading()
      }
    })
  }
})
