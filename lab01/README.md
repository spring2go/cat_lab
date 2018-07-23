实验一、CAT本地部署
======

### 实验步骤

#### 1. 下载CAT源码

```
git clone https://github.com/dianping/cat.git
```

#### 2. 构建cat war包

```
mvn clean install -DskipTests
```

将`{CAT_SRC}/cat-home/target/cat-alpha-2.0.0.war`重命名为`cat.war`

#### 3. 创建数据库

在mysql中创建`cat`数据库，导入脚本`{CAT_SRC}/script/Cat.sql`

#### 4. 拷贝并更新配置文件

在CAT运行盘建`data\appdatas\cat`目录，将`{CAT_SRC}/script/`下列配置文件：

*  CAT客户端配置文件client.xml
*  CAT服务器数据源配置文件datasources.xml
*  CAT服务器配置文件server.xml

都复制到`data\appdatas\cat`目录下：


本地配置案例如下：

CAT客户端配置文件client.xml
```xml
<?xml version="1.0" encoding="utf-8"?>

<config mode="client" xmlns:xsi="http://www.w3.org/2001/XMLSchema" xsi:noNamespaceSchemaLocation="config.xsd">
	<servers>
		<!-- Local mode for development -->
		<server ip="192.168.7.70" port="2280" http-port="8080" />
		<!-- If under production environment, put actual server address as list. -->
		<!-- 
			<server ip="192.168.7.71" port="2280" /> 
			<server ip="192.168.7.72" port="2280" /> 
		-->
	</servers>
</config>
```

CAT服务器数据源配置文件datasources.xml
```xml
<?xml version="1.0" encoding="utf-8"?>

<data-sources>
	<data-source id="cat">
		<maximum-pool-size>3</maximum-pool-size>
		<connection-timeout>1s</connection-timeout>
		<idle-timeout>10m</idle-timeout>
		<statement-cache-size>1000</statement-cache-size>
		<properties>
			<driver>com.mysql.jdbc.Driver</driver>
			<url><![CDATA[jdbc:mysql://127.0.0.1:3306/cat]]></url>
			<user>root</user>
			<password>mysql</password>
			<connectionProperties><![CDATA[useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&socketTimeout=120000]]></connectionProperties>
		</properties>
	</data-source>
	<data-source id="app">
		<maximum-pool-size>3</maximum-pool-size>
		<connection-timeout>1s</connection-timeout>
		<idle-timeout>10m</idle-timeout>
		<statement-cache-size>1000</statement-cache-size>
		<properties>
			<driver>com.mysql.jdbc.Driver</driver>
			<url><![CDATA[jdbc:mysql://127.0.0.1:3306/cat]]></url>
			<user>root</user>
			<password>mysql</password>
			<connectionProperties><![CDATA[useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&socketTimeout=120000]]></connectionProperties>
		</properties>
	</data-source>
</data-sources>

```

CAT服务器配置文件server.xml

```
<?xml version="1.0" encoding="utf-8"?>

<!-- Configuration for development environment-->
<config local-mode="false" hdfs-machine="false" job-machine="true" alert-machine="false">
	
	<storage  local-base-dir="/data/appdatas/cat/bucket/" max-hdfs-storage-time="15" local-report-storage-time="7" local-logivew-storage-time="7">
	
	</storage>
	
	<console default-domain="Cat" show-cat-domain="true">
		<remote-servers>127.0.0.1:8080</remote-servers>		
	</console>
		
</config>
```

#### 5. 部署war包

1. 将`cat.war`部署到tomcat的webapps目录下，启动tomcat
2. 打开cat控制台http://localhost:8080/cat
3. 配置全局路由，右上角`配置`，使用`catadmin/admin`登录，左边导航`全局告警配置->客户端路由`

本地路由配置案例
```xml
<?xml version="1.0" encoding="utf-8"?>
<router-config backup-server="192.168.7.70" backup-server-port="2280">
   <default-server id="192.168.7.70" weight="1.0" port="2280" enable="true"/>
</router-config>
```

#### 6. 校验CAT正常

通过导航`State`查看CAT状态，正常时显示`CAT服务端正常`字样，且CAT服务器会对自身进行监控，可通过导航`Transaction`查看。

如果服务器启动有问题，则可以通过查看日志解决：
1. `{CAT_HOME_DISK}:\data\applogs\cat`下面的CAT服务器日志
2. `{TOMCAT_HOME}\logs`下面的tomcat日志

### 部署参考

[CAT@github](https://github.com/dianping/cat)

