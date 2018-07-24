实验二、CAT埋点案例实验
======

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




