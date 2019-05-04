//list.js
//获取应用实例
const app = getApp()
Page({
  data: {
    newsList: [],
    lastid: 0,
    isfirst: 1,
    moreHidden: 'none'
  },
  loadData: function (lastid){
    // 点击加载更多后加载两条数据
    var limit = 2
    var that = this

    // 显示数据加载中的提示
    wx.showLoading({
      title: '数据加载中...',
    })

    wx.request({
      url: 'https://minapp.ngrok.xiaomiqiu.cn/minapp/query',
      data: { lastid: lastid, limit: limit},
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function(res) {
        if((res.data).length==0){
          wx.showToast({
            title: '没有更多文章了。。。',
            icon: 'fail',
            duration: 3000
          })
          that.setData({ moreHidden: 'none'})
          return false
        }
        // 获取数据的总长度
        var len = res.data.length
        // 取最后一条数据
        that.setData({ lastid: res.data[len-1].id})
        // 获取点击加载更多的新数据和上一次加载的数据进行合并
        var dataArr = that.data.newsList
        var newData = dataArr.concat(res.data)
        that.setData({
          // 绑定数据
          newsList: newData
        })
        that.setData({ moreHidden: '' })
      },
      complete: function(){
        // 隐藏数据加载中的提示
        wx.hideLoading()
      }
    })
  },
  loadMore: function(event){
    var that = this
    // 获取最后一个数据的下标，必须是有序的
    var id = event.currentTarget.dataset.lastid
    var isfirst = event.currentTarget.dataset.isfirst

    //  获取网络类型
    wx.getNetworkType({
      success: function(res) {
        // 返回网络类型 2g,3g,4g,wifi
        var networkType = res.networkType
        console.log(isfirst)
        if('wifi' != networkType && 1 == isfirst){
          wx.showModal({
            title: '温馨提示',
            content: '您现在不处于在WIFI的下，将会产生一定的流量费用',
            showCancel: false,
            success(res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } 
            }
          })
        }
      },
    })

    // 加载数据
    that.loadData(id)
    that.setData({isfirst: 0})
  },
  onLoad: function () {
    var that = this
    // 加载数据
    this.loadData(0)
  }
})
