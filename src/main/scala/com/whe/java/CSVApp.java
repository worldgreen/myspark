package com.whe.java;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CSVApp {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().appName("dataSet").master("local[2]").getOrCreate();


        Dataset<Row> csv = spark.read().option("header", true).option("inferSchema", true).csv("/Users/wanghongen/Documents/file/sales.csv");

        csv.show();


        spark.stop();
    }
}
