package com.whe.basic
import Array._
object Test {


    // 闭包
    var factor = 3;
    val multi = (i: Int) => factor * i

    // String
    val str = "ss"
    val sb = new StringBuilder
    sb ++= "fds"

    // 数组
    val arr = Array(1, 2, 3)

  // option
  val map = Map("a"-> "1", "b"->"2")
  val opt = map.get("a")

    def main(args: Array[String]): Unit = {
      println(multi(3))
      println(str.length)
      for (a <- arr) {
        println(a)
      }


      println(opt.get)

      val itor = map.iterator
      while (itor.hasNext) {
        println(itor.next)
      }
    }
}
