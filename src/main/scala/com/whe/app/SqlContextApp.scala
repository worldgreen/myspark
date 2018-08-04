package com.whe.app

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}


object SqlContextApp {
  def main(args: Array[String]): Unit = {

    val path = args(0)

    val sparkConf = new SparkConf()

    val sc = new SparkContext(sparkConf)

    val sqlC = new SQLContext(sc)

    val peo  = sqlC.read.format("json").load(path)
    peo.show()

    sc.stop()
  }

}


// submit shell

/*
 spark-submit \
   --class com.whe.SqlContextTest \
   --master local[2] \
   /Users/wanghongen/lib/myspark-1.0.jar \
  /Users/wanghongen/people.json
* */