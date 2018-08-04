# 单节点 Hadoop 安装

 - download hadoop   version 2.6.5
 - change etc/hadoop/
   - hadoop-env.sh
    ```sbtshell
     export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
    ```
   - core-site.xml
    ```xml
           <property>
              <name>fs.defaultFS</name>
                   <value>hdfs://localhost:9000/</value>
            </property>
            <property>
                   <name>hadoop.tmp.dir</name>
                   <value>/Users/wanghongen/workapp/hadoop-2.6.5/data/</value>
           </property>
    ``` 
    - hdfs-site.xml
    ```xml
                 <property>
                      <name>dfs.replication</name>
                       <value>1</value>
                 </property>
    ```
    - mapred-site.xml
    ```xml
                <property>
                        <name>mapreduce.framework.name</name>
                        <value>yarn</value>
                  </property>
    ```
    -  yarn-site.xml
    ```xml
         <property>
                          <name>yarn.resourcemanager.hostname</name>
                          <value>localhost</value>
                   </property>
                   <property>
                          <name>yarn.nodemanager.aux-services</name>
                          <value>mapreduce_shuffle</value>
                   </property>
    ```
 - 加环境变量 .bash_profile 
    ```sbtshell
    export HADOOP_HOME=/Users/wanghongen/workapp/hadoop-2.6.5
    export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
    ```
 - 格式化文件系统  
 
    bin/hdfs namenode -format
    
 - 启动NameNode和DataNode守护进程
 
    sbin/hadoop-daemon.sh start namenode  sbin/hadoop-daemon.sh start datanode
   
 - 访问前端 
   
    http://localhost:50070/
    
 - 启动ResourceManager和NodeManager守护程序
 
    sbin / start-yarn.sh
    
 - 浏览ResourceManager的Web界面
 
    http://localhost:8088/
    
 - 免密码启动Hadoop 
 
    cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
    
 