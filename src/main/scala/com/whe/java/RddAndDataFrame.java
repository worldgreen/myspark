package com.whe.java;

import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RddAndDataFrame {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().appName("app").master("local[2]").getOrCreate();

        JavaRDD<String> stringRDD = spark.sparkContext().textFile("/Users/wanghongen/people.txt", 2).toJavaRDD();

        JavaRDD<Row> map = stringRDD.map(line -> {
            String[] strs = line.split(",");
            return RowFactory.create(strs[0], Integer.parseInt(strs[1].trim()));
        });

        List<StructField> list = new ArrayList<>();
        list.add(DataTypes.createStructField("name", DataTypes.StringType, true));
        list.add(DataTypes.createStructField("age", DataTypes.IntegerType, true));
        StructType structType = DataTypes.createStructType(list);



        Dataset<Row> df = spark.createDataFrame(map, structType);

        df.filter(new Column("name").equalTo("cg")).show();


        df.createOrReplaceTempView("people");

        spark.sql("select * from people").show();

        spark.stop();

    }

    public void inferReflection() {
        SparkSession spark = SparkSession.builder().appName("app").master("local[2]").getOrCreate();

        RDD<String> stringRDD = spark.sparkContext().textFile("/Users/wanghongen/people.txt", 2);

        JavaRDD<People> rdd = stringRDD.toJavaRDD().map(line ->{
            String[] strs = line.split(",");
            People people = new People();
            people.setName(strs[0]);
            people.setAge(Integer.parseInt(strs[1].trim()));
            return people;
        });

        Dataset<Row> df = spark.createDataFrame(rdd, People.class).toDF();

        df.filter("age = 1").show();

   /*     df.createOrReplaceTempView("people");

        spark.sql("select * from people").show();
*/
        spark.stop();
    }
}

