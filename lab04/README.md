实验四、Spring Cloud Sleuth实验
======

### 实验步骤

#### 1. 启动本地Zipkin

参考[QuickStart](https://zipkin.io/pages/quickstart.html)下载`zipkin.jar`

```
java -jar zipkin.jar
```
默认zipkin服务器启动端点`9411`

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

#### 4. 通过zipkin查看调用链

```
http://localhost:9411/zipkin
```



