package com.whe.java;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;

public class SparkSessionApp {

    public static void main(String[] args) {

        // SparkSession
        SparkSession spark = SparkSession.builder().appName("sparkSession").master("local[2]").getOrCreate();

        // Creating DataFrames
        Dataset<Row> df = spark.read().json("/Users/wanghongen/people.json");

        // Untyped Dataset Operations
        df.printSchema();

        df.select("name").show();

        df.select(col("name"), col("age").plus(10).as("age2")).show();

        df.select(col("age").$greater(10)).show();

        df.select(col("name").isNotNull()).show();
        spark.close();


    }
}
