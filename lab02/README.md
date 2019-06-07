实验二、CAT埋点案例实验
======

### 注意(2019.6.7 update)

大众点评[CAT](https://github.com/dianping/cat)已经升级到3.0， Java应用配置方式和2.0不同，
上面四个SpringBoot项目的配置需要调整，配置请放在`src/main/resources/META-INF/app.properties`中，
里面只需说明应用名称即可，格式：

`app.name={appkey}`

同时，CAT客户端仍会统一读取`data\appdatas\cat\client.xml`中的客户配置信息。
具体参考[java客户端使用](https://github.com/dianping/cat/tree/master/lib/java)的Initialization部分。

### 实验步骤

#### 1. 启动本地CAT

参考[lab01](../lab01)

#### 2. 加载案例项目到Eclipse IDE

* [acme-financial-ui](acme-financial-ui):8081
* [acme-financial-back-office-microservice](acme-financial-back-office-microservice):8082
* [acme-financial-account-microservice](acme-financial-account-microservice):8083
* [acme-financial-customer-microservice](acme-financial-customer-microservice):8084

依次启动上述项目

#### 3. 调用API

通过postman分别调用如下API：

```
http://localhost:8081/start
http://localhost:8081/readtimeout
```

#### 4. 通过CAT查看调用链




