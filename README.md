# 0520ERP
 家具厂仓库管理系统

项目描述：这是关于仓库管理的一个demo，我将其改造为一个家具厂仓库管理的系统,其中业务代码和后台代码分开,分别在bus和sys文件夹下.显而易见,业务代码在bus文件夹下而sys是后台代码。


整个项目采用springboot + shiro + mybatis-plus 其中数据层的框架也用到了mybatis 因为业务需求需要用的多表关联。

亮点是采用了spring的AOP的切面编程，以及采用HashMap代替redis用作缓存使用,项目数据量不大，如果数据量大的话还是建议使用redis用作缓存。

前台页面交互采用的是layui轻量级模块化框架。

部署这个家具厂仓库管理系统时  在sql文件下 有个0520erp.sql  这是整个系统的建表语句，前提是得在mysql先建立0520erp数据库。

