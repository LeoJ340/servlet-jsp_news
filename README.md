# 基于servlet&jsp及原生jdbc开发的新闻系统项目
本项目采用[wangEditor富文本编辑器](http://www.wangeditor.com/)实现的文章发布的新闻系统，同时有前台展示。
文章发布不提供图片上传，因此新闻文章内容是纯文本的。
项目中的登录、后台等部分页面UI使用[bootstrap](http://bs4.vx.link/)官方提供的模板。<br/>
**注：** 该项目主要是本人为了复习JavaWeb知识而写的小项目。如果你正在学习JavaWeb或者需要练手的项目，那么这个项目应该会对你有帮助。<br/>
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
    管理员用户：
        管理员登录：进入管理员登录页面输入账号密码完成登录，若账号存在则登录成功，若不存在则登录失败并回显错误信息，在没有管理员登录的状态下不允许进入管理中心。
        发表文章：在后台管理系统编辑发表新文章。
        新闻分类管理：对新闻分类进行增删改操作。
        新闻管理：对新闻文章数据进行删除操作。
本项目仅仅是做了文章相关信息的简单增删改查和用户权限的控制，没有啥复杂的功能，所以没有什么好解释的了（捂脸，溜。。）<br/>

演示站点: http://116.62.108.219:8080/mininews/<br/>
后台入口：http://116.62.108.219:8080/mininews/admin<br/>
管理员账户：Leo <br/>
管理员密码：340 <br/>

### 项目结构
    ├── README.md 
    ├── config  -- 项目资源文件
    |      ├── news_table.sql 项目数据库创建和表创建的SQL语句
    |      ├── c3p0-config.xml c3p0连接池配置文件
    |      ├── dao.properties 
    |      └── service.properties
    └── src
    |    └── com
    |        └── jsj
    |             ├── servlet  web层
    |             ├── dao  -- dao持久层
    |             ├── entity  -- 实体类
    |             ├── factory  -- 工厂类
    |             ├── filter  -- 过滤器
    |             ├── utils  -- 工具类
    |             └── service  -- service业务层
    └── web
         └── WEB-INF
         |      ├── lib  -- 项目相关依赖
         |      ├── view  -- 视图页面目录
         |      └── web.xml  -- web部署文件
         └── static
                ├── bootstrap-4.3.1-dist  -- bootstrap依赖文件
                ├── wangEditor  -- 富文本编辑器依赖文件
                ├── css  -- 样式文件
                ├── images  -- 图片文件
                └── js  -- javascript脚本文件
### 结果展示
#### 首页：
![Image text](https://github.com/Lionel340/servlet-jsp_news/blob/master/md_image/index.png)
#### 新闻分类列表：
![Image text](https://github.com/Lionel340/servlet-jsp_news/blob/master/md_image/newslist.png)
#### 新闻详细页面
![Image text](https://github.com/Lionel340/servlet-jsp_news/blob/master/md_image/news.png)
#### 管理中心发表新闻文章页面
![Image text](https://github.com/Lionel340/servlet-jsp_news/blob/master/md_image/publish.png)
#### 新闻管理中心
![Image text](https://github.com/Lionel340/servlet-jsp_news/blob/master/md_image/newsManage.png)
#### 新闻分类管理中心
![Image text](https://github.com/Lionel340/servlet-jsp_news/blob/master/md_image/newsCateManage.png)
