package com.whe.app

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

object HiveContextIdeaApp {

  // add hive-site.xml in resources

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf();

    sparkConf.setAppName("fdd").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)

    val hiveCon = new HiveContext(sc)

    hiveCon.table("employee").show()

    sc.stop()
  }
}

