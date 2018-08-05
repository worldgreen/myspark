package com.whe.app

import java.sql.DriverManager

object SparkSQLThriftServerIdeaApp {

  def main(args: Array[String]): Unit = {

    Class.forName("org.apache.hive.jdbc.HiveDriver")

    val conn = DriverManager.getConnection("jdbc:hive2://localhost:10000 ", "mmaaa", "")

    val pstmt = conn.prepareStatement("select * from employee")

    val rs = pstmt.executeQuery()

    while (rs.next()) {
      println()
    }

    rs.close()
    pstmt.close()
    conn.close()

  }

}
