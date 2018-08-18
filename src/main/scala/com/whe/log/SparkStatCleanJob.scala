package com.whe.log

import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkStatCleanJob {

  val spark = SparkSession.builder().appName("SparkSessionIdeaApp").master("local[2]").getOrCreate();

  val access = spark.sparkContext.textFile("file:///user/df")

  val accessDF = spark.createDataFrame(access.map(x => AccessConvertUtil.parseLog(x)), AccessConvertUtil.struct)

  accessDF.coalesce(1).write.mode(SaveMode.Overwrite).parquet("file:///user/df")

  spark.stop()
}
