package com.whe.app

import java.io.{FileNotFoundException, FileReader, IOException}

import scala.util.matching.Regex
object Basic {

  def main(args: Array[String]): Unit = {

  /*  printArr("1", "2")
    println(countSum(9))
    println(countSum())
    println(apply(layout, 3))
    println(Sum(1, 3, 4))
    println(sum(2, 3))
    println(sumWith2(2))
    println(s0m(1)(3))*/



    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("Missing file exception")
      }
    } finally {
      println("Exiting finally...")
    }

    val pattern = new Regex("(S|s)cala")
    val str = "Scala is scalable and cool"
    println((pattern findAllIn str).mkString(","))
    println(pattern replaceFirstIn(str, "fs"))

  }


  // 可变长参数
  def printArr(arr: String*): Unit = {
    for (x <- arr) {
      println(x)
    }
  }

  // 递归
  def countSum(num: Int): Int = {
    if (num == 1)
      1
    else
      num + countSum(num - 1)
  }

  // 默认参数
  def countSum(a: Int = 5, b: Int = 7): Int = {
    return a + b
  }

  // 高阶函数
  def apply(f : Int => String, v: Int) = f(v)

  def layout[A](a: A) = "[" + a.toString + "]"

  // 函数嵌套
  def Sum(a: Int, b: Int, c: Int): Int = {

    def SumTwo(d: Int, e: Int): Int = {
      d + e
    }
    SumTwo(a, b) + SumTwo(c, b)
  }

  //匿名函数

  val sum = (a: Int, b: Int) => a + b

  // 便应用函数

  val sumWith2 = countSum(4, _ : Int)

  // 函数柯里化
  def s0m(a: Int)(b: Int) = {
    a + b
  }


}


