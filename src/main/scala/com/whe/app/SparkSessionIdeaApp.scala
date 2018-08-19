package com.whe.app


import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

import org.apache.commons.lang.time.FastDateFormat
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}

object SparkSessionIdeaApp {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("name").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("/Users/wanghongen/Documents/file/people.txt", minPartitions = 3)
    rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect()
    sc.stop()
  }
}
