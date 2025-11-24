App({
  onLaunch() {
    // 初始化本地存储
    if (!wx.getStorageSync('settings')) {
      // 默认设置
      const defaultSettings = {
        minValue: 0,
        maxValue: 100,
        challengeMode: false,
        maxAttempts: 10,
        showIntro: true
      };
      wx.setStorageSync('settings', defaultSettings);
    }
    
    // 初始化历史记录
    if (!wx.getStorageSync('gameHistory')) {
      wx.setStorageSync('gameHistory', []);
    }
  },
  
  globalData: {
    currentGame: null
  }
});