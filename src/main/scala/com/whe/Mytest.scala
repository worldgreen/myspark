package com.whe

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext

object Mytest {

  def main(args: Array[String]): Unit = {

    val path = args(0)

    val sparkConf = new SparkConf()

/*    sparkConf.setAppName("dfdf").setMaster("local[2]")*/

    val sc = new SparkContext(sparkConf)

    val sqlC = new SQLContext(sc)

    val peo  = sqlC.read.format("json").load(path)
    peo.show()

    sc.stop()
  }

}
