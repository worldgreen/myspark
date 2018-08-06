package com.whe.app_
import org.apache.spark.sql.{SparkSession, TiContext}
object TiSparkIdeaApp {

  def main(args: Array[String]): Unit = {

  val spark = SparkSession.builder().config("spark.tispark.pd.addresses", "10.15.235.112:2379").getOrCreate();
    import spark.implicits._
  val ti = new TiContext(spark)
    ti.tidbMapDatabase("didmapping")



    // 创建  DataFrames
    val df = spark.sql("select * from device")
    val rs = df.groupBy("os_type", "os_version").count().toDF()
    rs.write.format("jdbc")
      .option("url", "jdbc:mysql://10.15.235.112:4000/didmapping")
      .option("dbtable", "os_count")
      .option("user", "didmappingadmin")
      .option("password", "c9d7gwu#")
      .save()



/*
    // Dataset 操作
    val df = spark.sql("select * from device")
    df.printSchema()
    df.select("os_type").show()
    df.groupBy("os_type", "os_version").count().show
*/

/*    // 执行sql 查询
    df.createOrReplaceTempView("device")
    val sqlDF = spark.sql("SELECT * FROM device")
    sqlDF.show()*/

/*
    // 全局临时视图
    df.createGlobalTempView("device")
    spark.sql("SELECT * FROM global_temp.device").show()
  //  spark.newSession().sql("SELECT * FROM global_temp.device").show()
*/

/*
    // 创建 Datasets
    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.map(_ + 1).collect()

*/

    // 与RDDS的交互

  }

}
