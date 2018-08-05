# 安装 hive  
 version  2.3.3  本地模式（本地安装mysql 替代derby存储元数据）
 
 1. 下载 version  2.3.3 
 2. 加环境变量 .bash_profile 
    ```sbtshell
      export HIVE_HOME=/Users/wanghongen/workapp/apache-hive-2.3.3
      export PATH=$PATH:$HIVE_HOME/bin
    ```
 3. mysql驱动包放置到$HIVE_HOME\lib目录
 4. 创建metastore数据库并为其授权
    ```sbtshell
    create database metastore;
    CREATE USER 'hive'@'%' IDENTIFIED BY 'hive';
    grant all on metastore.* to hive@'%';
    flush privileges;
    ```
 5. 修改hive配置文件 /conf
    
    - 复制初始化文件并重改名
    ```sbtshell
    cp hive-env.sh.template hive-env.sh
    cp hive-default.xml.template hive-site.xml
    cp hive-log4j2.properties.template hive-log4j2.properties
    cp hive-exec-log4j2.properties.template hive-exec-log4j2.properties
    ```
    - 修改hive-env.sh
     ```sbtshell
      export JAVA_HOME=/usr/local/jdk1.7.0_80    ##Java路径
      export HADOOP_HOME=/usr/local/hadoop   ##Hadoop安装路径
      export HIVE_HOME=/usr/local/hive    ##Hive安装路径
      export HIVE_CONF_DIR=/usr/local/hive/conf    ##Hive配置文件路径
     ```
    - 在hdfs 中创建下面的目录 ，并且授权
    ```sbtshell
     hdfs dfs -mkdir -p /user/hive/warehouse
     hdfs dfs -mkdir -p /user/hive/tmp
     hdfs dfs -mkdir -p /user/hive/log
     hdfs dfs -chmod -R 777 /user/hive/warehouse
     hdfs dfs -chmod -R 777 /user/hive/tmp
     hdfs dfs -chmod -R 777 /user/hive/log
    ```
    - 修改hive-site.xml
    ```xml
     <property>
         <name>hive.exec.scratchdir</name>
         <value>/user/hive/tmp</value>
     </property>
     <property>
         <name>hive.metastore.warehouse.dir</name>
         <value>/user/hive/warehouse</value>
     </property>
     <property>
         <name>hive.querylog.location</name>
         <value>/user/hive/log</value>
     </property>
     
     ## 配置 MySQL 数据库连接信息
     <property>
         <name>javax.jdo.option.ConnectionURL</name>
         <value>jdbc:mysql://localhost:3306/metastore?createDatabaseIfNotExist=true&amp;characterEncoding=UTF-8&amp;useSSL=false</value>
       </property>
       <property>
         <name>javax.jdo.option.ConnectionDriverName</name>
         <value>com.mysql.cj.jdbc.Driver</value>
       </property>
       <property>
         <name>javax.jdo.option.ConnectionUserName</name>
         <value>hive</value>
       </property>
       <property>
         <name>javax.jdo.option.ConnectionPassword</name>
         <value>hive</value>
       </property>
    ```
    
 6. 初始化hive 
    
    schematool -dbType mysql -initSchema hive hive
    
 7. 启动hive
 
    hive