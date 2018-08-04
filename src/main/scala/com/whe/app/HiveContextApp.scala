package com.whe.app

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object HiveContextApp {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf();

    val sc = new SparkContext(sparkConf)

    val hiveCon = new HiveContext(sc)

    hiveCon.table("emp").show()

    sc.stop()
  }
}


//  sheel

/*
 spark-submit \
   --class com.whe.HiveContextApp \
   --master local[2] \
   --jars /Users/wanghongen/software/mysql-connector-java-5.1.21-bin.jar \
   /Users/wanghongen/lib/myspark-1.0.jar

* */
