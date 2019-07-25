# 基于servlet&jsp及原生jdbc开发的新闻项目
### 项目环境
    Java环境：jdk1.8+
    数据库环境：MySql8 + c3p0连接池
    集成开发环境：Idea 2019
    web容器：Tomcat 9
### 需求分析
    普通用户：
        用户注册：用户进入注册页面，输入相关信息并点击注册，系统将账号信息存入数据库。
        用户登录：用户输入用户名和密码，若账号存在则登录成功，若不存在则登录失败并回显错误信息，可记住登录密码为期一周。
        选择新闻分类：点击新闻首页的分类导航进入对应分类的新闻列表。
        新闻详情：点击新闻标题链接，进入新闻详细页面浏览文章。
        评论/回复：敬请期待~。
    管理员用户：
        管理员登录：进入管理员登录页面输入账号密码完成登录，若账号存在则登录成功，若不存在则登录失败并回显错误信息，在没有管理员登录的状态下不允许进入管理中心。
        发表文章：在后台管理系统编辑发表新文章。
        新闻分类管理：对新闻分类进行增删改操作。
        新闻管理：对新闻文章数据进行删除操作。

### 结果截图展示
#### 首页：
![Image text](https://github.com/JsjCode/servlet-jsp_news/blob/master/md_image/index.png)
#### 新闻详细页面
![Image text](https://github.com/JsjCode/servlet-jsp_news/blob/master/md_image/news.png)
#### 管理中心发表新闻文章页面
![Image text](https://github.com/JsjCode/servlet-jsp_news/blob/master/md_image/publish.png)
#### 新闻管理中心
![Image text](https://github.com/JsjCode/servlet-jsp_news/blob/master/md_image/newsManege.png)
#### 新闻分类管理中心
![Image text](https://github.com/JsjCode/servlet-jsp_news/blob/master/md_image/newsCateManage.png)
