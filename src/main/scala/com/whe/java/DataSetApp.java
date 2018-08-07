package com.whe.java;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DataSetApp {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().appName("dataSet").master("local[2]").getOrCreate();

        JavaRDD<String> javaRDD = spark.sparkContext().textFile("/Users/wanghongen/Documents/file/student.data", 2).toJavaRDD();

        JavaRDD<Student> map = javaRDD.map(line -> {
            Student student = new Student();
            String[] strs = line.split("\\|");
            student.setId(Integer.parseInt(strs[0]));
            student.setName(strs[1]);
            student.setPhone(strs[2]);
            student.setEmail(strs[3]);
            return student;
        });

        Dataset<Row> df = spark.createDataFrame(map, Student.class);
        df.show();
        spark.stop();
    }
}
