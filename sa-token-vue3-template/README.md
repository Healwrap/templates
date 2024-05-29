# Sa-Token 模板

## 项目介绍

此项目是使用jdk11 + springboot2.5.14 + satoken + mybatisplus3.4.3的一个简单的模板（注意各依赖版本需对应，否则出现报错）

## 项目使用

1. 本机上应有mysql + redis，并创建一个数据库，其中需要至少一个数据库表名为sys_user
2. 修改application.yml中的数据库连接信息
3. 启动项目，访问http://localhost:8081/

## 项目结构

```
sa-token-template
├── src
│   ├── main
│   │   ├── java
│   │   │   └── cn
│   │   │       └── pepedd
│   │   │           ├── annotation											
│   │   │           │   └── VerifyCaptcha.java						# 校验验证码注解
│   │   │           ├── aop
│   │   │           │   └── VerifyCaptchaAop.java					# 校验验证码实现
│   │   │           ├── captcha
│   │   │           │   ├── CaptchaConfig.java						# 验证码配置
│   │   │           │   └── KaptchaTextCreator.java				# 验证码生成器(不用动)
│   │   │           ├── config
│   │   │           │   ├── CorsConfig.java								# 跨域配置
│   │   │           │   └── WebMvcConfig.java							# mvc配置
│   │   │           ├── constants
│   │   │           │   ├── CacheConstants.java						# 缓存常量
│   │   │           │   └── Constants.java								# 字符常量
│   │   │           ├── controller
│   │   │           │   ├── AuthController.java
│   │   │           │   ├── IndexController.java
│   │   │           │   └── UserController.java
│   │   │           ├── entity
│   │   │           │   ├── dto
│   │   │           │   │   ├── LoginBodyDTO.java
│   │   │           │   │   └── RegisterBodyDTO.java
│   │   │           │   ├── pojo
│   │   │           │   │   └── User.java
│   │   │           │   ├── result
│   │   │           │   │   └── R.java
│   │   │           │   └── vo
│   │   │           │       ├── LoginVO.java
│   │   │           │       └── UserVO.java
│   │   │           ├── handler
│   │   │           │   ├── GlobalExceptionHandler.java			# 全局异常处理器
│   │   │           │   └── MyMetaObjectHandler.java				# 自动填充字段
│   │   │           ├── json
│   │   │           │   └── JacksonObjectMapper.java				# json序列化
│   │   │           ├── mapper
│   │   │           │   └── UserMapper.java									# 用户mapper
│   │   │           ├── redis
│   │   │           │   ├── RedisCache.java									# redis 缓存
│   │   │           │   └── RedisConfig.java								# redis 配置
│   │   │           ├── satoken
│   │   │           │   └── SaTokenConfigure.java						# sa-token配置
│   │   │           ├── service
│   │   │           │   ├── impl
│   │   │           │   │   └── UserServiceImpl.java				# 用户接口实现
│   │   │           │   ├── IAuthService.java								 # 校验接口
│   │   │           │   └── IUserService.java								 # 用户接口
│   │   │           └── Main.java															# 主入口
│   │   └── resources
│   │       └── application.yml																 # 配置文件
│   └── test
│       └── java
├── README.md																										# 说明文件
└── pom.xml																											# 各依赖的版本

```



## 项目接口

在http://localhost:8081/doc.html下可查看项目的所有接口

文档使用的是knife4j

在接口上使用注解即可实现定义接口

![image-20240306001219865](https://picgo-img-repo.oss-cn-beijing.aliyuncs.com/img/e2af73f1622486d853e4da2a4368fdca.png)



## 项目依赖



```xml
<!--lombok-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
<!-- Sa-Token 权限认证，在线文档：https://sa-token.cc -->
<dependency>
    <groupId>cn.dev33</groupId>
    <artifactId>sa-token-spring-boot-starter</artifactId>
    <version>${satoken.version}</version>
</dependency>
<!-- redis 缓存操作 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>${spring-boot.version}</version>
</dependency>
<!--切面-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
    <version>${spring-boot.version}</version>
</dependency>
<!--注解-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<!--mysql 驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql.version}</version>
</dependency>
<!--mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>${mybatis-plus.version}</version>
</dependency>
<!--hutool-->
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>${hutool.version}</version>
</dependency>
<!-- 验证码 -->
<dependency>
    <groupId>pro.fessional</groupId>
    <artifactId>kaptcha</artifactId>
    <version>${kaptcha.version}</version>
    <exclusions>
        <exclusion>
            <artifactId>javax.servlet-api</artifactId>
            <groupId>javax.servlet</groupId>
        </exclusion>
    </exclusions>
</dependency>
<!-- 解析客户端操作系统、浏览器等 -->
<dependency>
    <groupId>eu.bitwalker</groupId>
    <artifactId>UserAgentUtils</artifactId>
    <version>${bitwalker.version}</version>
</dependency>
<!--接口文档-->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>${knife4j.version}</version>
</dependency>
```

