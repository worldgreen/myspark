package com.whe.log

import org.apache.spark.sql.SparkSession

object SparkStatFormatJob {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkSessionIdeaApp").master("local[2]").getOrCreate();

    val access = spark.sparkContext.textFile("file:///user/df")

    access.map(line => {
      val splits = line.split(" ")
      val time = splits(0)
      val ip = splits(1)
      time + "\t" + ip
    }).saveAsTextFile("file:///user/df")

    spark.close()
  }

}
