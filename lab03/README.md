实验三、Zuul网关集成CAT实验
======

### 实验步骤

#### 1. 启动本地CAT

参考[lab01](../lab01)

#### 2. 启动案例项目

参考[lab02](../lab02)

#### 3. 启动Zuul网关

参考:
* [zuul定制版源码](https://github.com/spring2go/s2g-zuul)
* [zuul lab](https://github.com/spring2go/zuul_lab)

注意：

* 修改Zuul端口为`9000`
* 修改`mobile_zuul.properties`中的路由配置：

```
zuul.routing_table_string=acme@http://localhost:8081
```

#### 4. 调用API

通过postman分别调用如下API：

```
http://localhost:9000/api/acme/start
http://localhost:9000/api/acme/readtimeout
```

#### 5. 通过CAT查看调用链




