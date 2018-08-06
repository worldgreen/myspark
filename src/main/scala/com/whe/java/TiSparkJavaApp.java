package com.whe.java;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.TiContext;

public class TiSparkJavaApp {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().config("spark.tispark.pd.addresses", "10.15.235.112:2379").getOrCreate();
        TiContext tiContext = new TiContext(spark);
        tiContext.tidbMapDatabase("didmapping", false, false);
        Dataset<Row> sql = spark.sql("select count(*) from device");
        sql.show();
        spark.close();
    }

}
