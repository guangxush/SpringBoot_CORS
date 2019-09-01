# SpringBoot_CORS

## CORS跨域访问
## RestTemplate请求url获取Data

### 什么是跨域访问（CORS）

CORS是一个W3C标准，全称是"跨域资源共享"（Cross-origin resource sharing）。
它允许浏览器向跨源服务器，发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制。

### 跨域原理

- 跨域只存在于浏览器端，不存在于安卓/ios/Node.js/python/ java等其它环境；
- 跨域请求能发出去，服务端能收到请求并正常返回结果，只是结果被浏览器拦截了；
- 之所以会跨域，是因为受到了同源策略的限制，同源策略要求源相同才能正常进行通信，即协议、域名、端口号都完全一致。

### 跨域访问介绍

举个例子：假设虚假网站中存在一个form表单，用户填写之后可以根据真实的路由向真实网站请求数据，真实网站接收到用户请求之后返回所需数据，这时候如果虚假网站可以直接接收的话，可以把请求结果保存下来，从而窃取用户的信息。
![跨域访问限制.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors1.png)

#### 官方形象化解释：
ajax或者iframe指向的地址中，二级域名、端口、协议必须与主页面完全相同，否则就算跨域

![跨域访问原理.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors2.png)

### 需求介绍

但是如果在一个项目中同时定义了多个服务，每个服务之间的端口号不一致，那么如何从一个服务调用另一个服务的接口呢？

该[项目](https://github.com/guangxush/SpringBoot_CORS
)中（里面的具体需求不在描述,，可自行git查看）下面有多个Module服务，cors用于处理用户的信息，web模块用于展示用户的信息（为了举例子，故意分开写），这时web(8080端口)需要用到cors（8081端口）下面请求用户数据的接口，但是由于端口号不一致，即使在同一个域名下也无法正常访问
![项目框架.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors3.png)
![7632302-b196665beb89b6bf.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors4.png)

直接输入id并点击查询，请求会被拦截：

浏览器提示index.html请求cors用户信息报错：

![浏览器对请求拦截.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors5.png)


### 解决方案

使用Java配置cors[CorsConfig.java](https://github.com/guangxush/SpringBoot_CORS/blob/master/cors/src/main/java/com/shgx/cors/config/CorsConfig.java "CorsConfig.java")，使得整个应用都支持CORS（跨域访问解决方案很多，这里简单介绍一个）

```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 页面跨域访问Controller过滤
     *
     * @return
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }
}

```
此时再次进行查询数据获取成功：
![添加跨域访问配置并成功返回cors中信息.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors6.png)

### 部分接口跨域访问

但是如果cors中包含多个接口，只想暴露一部分出去应该怎么配置？
可以更改Mapping：
```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 页面跨域访问Controller过滤
     *
     * @return
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/open/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }
}

```
只开放部分接口
测试结果如下：
下图中从上到下按钮访问依次介绍：
- “查询”按钮访问外部cors下面的开放接口：[UserController.java](https://github.com/guangxush/SpringBoot_CORS/blob/master/cors/src/main/java/com/shgx/cors/controller/UserController.java "UserController.java")
- “测试1”按钮访问web下面的本地接口：[NativeController.java](https://github.com/guangxush/SpringBoot_CORS/blob/master/web/src/main/java/com/shgx/web/controller/NativeController.java "NativeController.java")
- “测试2”按钮访问cors下面的封闭接口：[AnotherController.java](https://github.com/guangxush/SpringBoot_CORS/blob/master/cors/src/main/java/com/shgx/cors/controller/AnotherController.java "AnotherController.java")

测试结果如下图所示：
- 外部“查询”访问成功
- 本地“测试”访问成功
- 外部“测试”访问失败
![跨域访问开放部分接口.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors6.png)

### 配置需要注意的地方
 如果在[application.properties](https://github.com/guangxush/SpringBoot_CORS/blob/master/cors/src/main/resources/application.properties "application.properties")中已经配置了访问路由，如下图所示：
![访问路由配置.png](https://github.com/guangxush/iTechHeart/blob/master/image/CORS/cors6.png)
请不要在跨域访问的配置文件[CorsConfig.java](https://github.com/guangxush/SpringBoot_CORS/blob/master/cors/src/main/java/com/shgx/cors/config/CorsConfig.java "CorsConfig.java")再次中添加该路由（如下图所示），否则会导致匹配失败的情况
```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 页面跨域访问Controller过滤
     *
     * @return
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/operation/open/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }
}

```

