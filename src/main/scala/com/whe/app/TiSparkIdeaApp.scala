package com.whe.app

import org.apache.spark.sql.{SparkSession, TiContext}

object TiSparkIdeaApp {

  def main(args: Array[String]): Unit = {

  val spark = SparkSession.builder().appName("SparkSessionIdeaApp").config("spark.tispark.pd.addresses", "10.15.235.112:2379").master("local[2]").getOrCreate();

  val ti = new TiContext(spark)

    ti.tidbMapDatabase("didmapping")
    spark.sql("show tables").show()
    spark.stop()
  }

}
