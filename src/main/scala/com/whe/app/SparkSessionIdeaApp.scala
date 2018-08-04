package com.whe.app

import org.apache.spark.sql.SparkSession

object SparkSessionIdeaApp {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkSessionIdeaApp").master("local[2]").getOrCreate();

    val people = spark.read.json("file:///Users/wanghongen/people.json")

    people.show()

    spark.stop()
  }
}
