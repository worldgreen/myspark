# 安装sprark 
version 2.1.1  
 
1. 下载 spark 2.1.1  源码
2. 编译源码

    ./dev/make-distribution.sh --name hadoop2.6.5 --tgz -Pyarn -Phadoop-2.6 -Phive -Phive-thriftserver -Dhadoop.version=2.6.5 -DskipTests clean package
    
#  local 模式
1. 启动

   spark-shell --master local[2]
   
#  standalone 
1. 配置 spark-env.sh
   ```sbtshell
   SPARK_MASTER_HOST=localhost
   SPARK_WORKER_CORES=1
   SPARK_WORKER_MEMORY=1g
   SPARK_WORKER_INSTANCES=2
   ```
2. 服务器启动
   
   /sbin/start-all.sh 
   
3. 前端界面
  
   http://localhost:8080/
   
3. 启动客户端

   ./spark-shell --master spark://localhost:7077

# thriftserver/beeline
1. 启动服务
  
   start-thriftserver.sh --master local[2]
   
2. 启动beeline

    beeline -u jdbc:hive2://localhost:10000 -n mmaa