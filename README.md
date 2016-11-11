# BookmarkHelper
## 这是什么？
BookmarkHelper（书签助手）是一款Android平台下，浏览器书签转换工具类APP，运行时需要Root权限，目标全面兼容主流Android浏览器相互转换书签数据，暂未考虑支持iOS或桌面端。

使用举例：从[Chrome浏览器](http://www.coolapk.com/apk/com.android.chrome)中，提取用户书签数据，追加合并到[Via浏览器](http://www.coolapk.com/apk/mark.via)，带你轻松脱坑，成功用上最牛逼浏览器！

BookmarkHelper是个人作品，持续维护，永不考虑收费推广，不滥用Root权限，使用完毕可立即卸载，运行时不需连接网络。如果你用的爽，可以[鼓励一下](https://www.kisscat.pro/rewards/wechat-reward-image.png)，我将用于：支付VPS月租，开发更多精彩APP，谢谢您的点滴支持！

![使用教程Gif：5.8MB](http://ww2.sinaimg.cn/mw690/becd6b85gw1f9oaniwbdig208e0dwu11.gif)

## 版本计划
### [0.0.1版 Release](https://github.com/amao12580/BookmarkHelper/raw/master/origin/release/0.0.1%E7%89%88/pro.kisscat.www.bookmarkhelper_0.0.1.apk)
支持从[Chrome浏览器](http://www.coolapk.com/apk/com.android.chrome)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。
### [0.0.2版 Release](https://github.com/amao12580/BookmarkHelper/raw/master/origin/release/0.0.2%E7%89%88/pro.kisscat.www.bookmarkhelper_0.0.2.apk)
1.增加兼容：支持从Flyme5自带浏览器提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

2.当rom不是flyme时，如果rom存在包名为：com.android.browser的浏览器，也可以用Flyme5的规则，一般的内置浏览器都是这个包名。

3.Flyme4.X系列的rom暂未测试，没有设备。如您感兴趣，请与我联系，见下方的邮件地址！

4.Via合并书签修复bug，增强稳定性，现在安装via，但是没有打开过，将不能合并，最少需要您手动打开一次！
### [0.0.3版 Release](https://github.com/amao12580/BookmarkHelper/raw/master/origin/release/0.0.3%E7%89%88/pro.kisscat.www.bookmarkhelper_0.0.3.apk)
1.增加兼容：支持从[UC浏览器](http://www.coolapk.com/apk/com.UCMobile)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

2.界面大调整，美美哒！

3.部分代码重构，精简掉重合代码段。
### [0.0.4版 Release](https://github.com/amao12580/BookmarkHelper/raw/master/origin/release/0.0.4%E7%89%88/pro.kisscat.www.bookmarkhelper_0.0.4.apk)
1.增加兼容：支持从[QQ浏览器](http://www.coolapk.com/apk/com.tencent.mtt)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

2.底栏小Tip，关于我、五星好评、捐助
### [0.0.5版 Release](https://github.com/amao12580/BookmarkHelper/raw/master/origin/release/0.0.5%E7%89%88/pro.kisscat.www.bookmarkhelper_0.0.5.apk)
1.增加兼容：支持从[X浏览器](http://www.coolapk.com/apk/com.mmbox.xbrowser)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

2.Bug 修复：[QQ浏览器](http://www.coolapk.com/apk/com.tencent.mtt)支持读取QQ用户登录的书签数据，微信登录的还在修复中。

3.Bug 修复：[UC浏览器](http://www.coolapk.com/apk/com.UCMobile)支持读取QQ和微信用户登录的书签数据。

4.延迟对Root权限的检查和获取！

5.日志记录进行异步化，不再阻塞主线程

### [0.0.6版 Release](https://github.com/amao12580/BookmarkHelper/raw/master/origin/release/0.0.6%E7%89%88/pro.kisscat.www.bookmarkhelper_0.0.6.apk)
1.增加兼容：支持从[360浏览器](http://www.coolapk.com/apk/com.qihoo.browser)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

2.Bug 修复：[Chrome浏览器](http://www.coolapk.com/apk/com.android.chrome)现在支持读取完整的书签数据。

3.Bug 修复：[QQ浏览器](http://www.coolapk.com/apk/com.tencent.mtt)支持读取微信用户登录的书签数据。

4.优化：减少主循环中日志打印，避免UI响应超时！

5.背景线程处理书签交换，避免UI响应超时

### 0.0.7版 Draft
1.增加兼容：支持从[搜狗浏览器](http://www.coolapk.com/apk/sogou.mobile.explorer)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

### 0.0.8版 Draft
1.增加兼容：支持从[百度浏览器](http://www.coolapk.com/apk/com.baidu.browser.apps)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

### 0.0.9版 Draft
1.增加兼容：支持从[欧朋浏览器](http://www.coolapk.com/apk/com.oupeng.mini.android)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

### 0.0.10版 Draft
1.增加兼容：支持从[猎豹浏览器](http://www.coolapk.com/apk/com.ijinshan.browser_fast)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

### 0.0.11版 Draft
1.增加兼容：支持从[FireFox浏览器](http://www.coolapk.com/apk/org.mozilla.firefox)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。

### 0.0.12版 Draft
1.增加兼容：支持从[UC国际版浏览器](http://www.coolapk.com/apk/com.UCMobile.intl)提取书签，追加到[Via浏览器](http://www.coolapk.com/apk/mark.via)。


## UnStable
UnStable是指最新通过基础测试，但未进行大面积设备兼容验证的非稳定版本，不会发布到[Google Play](https://play.google.com/store?hl=zh_CN)或[Cool Market](http://www.coolapk.com)。如果你是狂热爱好者，请点击【[下载链接](https://github.com/amao12580/BookmarkHelper/raw/master/app/build/outputs/apk/app-debug.apk)】，从我的[Github Repo](https://github.com/amao12580/BookmarkHelper)实时获取，不保证会有小瑕疵。



## Bug & 反馈
由于个人精力有限，没有大量设备供测试，如您遇到使用问题，请发送log文件（SD路径：BookmarkHelper/logs/*Log.txt）到Mail：stevenchengmask # gmail.com，我将尽快答复您的疑问！同时也欢迎您的来信建议，我将最短时间内答复您！