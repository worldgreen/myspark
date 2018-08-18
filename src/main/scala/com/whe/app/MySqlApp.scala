package com.whe.app

import org.apache.spark.sql._
import org.apache.spark.sql.types.{StringType, StructField, StructType}
object MySqlApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SparkSessionIdeaApp").master("local[2]").getOrCreate()
    import spark.implicits._
    val text = spark.sparkContext.textFile("/Users/wanghongen/Documents/file/people.txt")
    val fields = "name age".split(" ").map(line => StructField(line, StringType, nullable = true))
    val schema = StructType(fields)
    val rows = text.map(_.split(",")).map(line => Row(line(0), line(1).trim))
    val df = spark.createDataFrame(rows, schema)
    df.show()

/*    val df = spark.sparkContext.textFile("/Users/wanghongen/Documents/file/people.txt").map(_.split(","))
      .map(row => App(row(0), row(1).trim.toLong)).toDF()
    df.show()*/



/*
    val ds = Seq(App("i", 1), App("2", 2)).toDS()
    val ds2 = spark.read.json("/Users/wanghongen/Documents/file/people.json").as[App]
    ds2.show()*/


/*
    df.createOrReplaceGlobalTempView("people")
    spark.sql("select name from global_temp.people").show()
    spark.newSession().sql("select age from global_temp.people").show()
*/


/*    df.createOrReplaceTempView("people")
    spark.sql("select name from people").show()*/

/*    df.select("name").show()
    df.select($"name", $"age" + 1).show()
    df.groupBy("age").count().show()
    */


    import spark.implicits._
    import org.apache.spark.sql._
/*    val res = df.map((line: Row) => {
      if (line.isNullAt(0))
         App("fdsx", 1)
      else
        App("fdsx", 0)
    })

    res.show()
    df.printSchema()
    spark.close()*/

    spark.stop()
  }

  case class App(name: String, age: Long)
}
