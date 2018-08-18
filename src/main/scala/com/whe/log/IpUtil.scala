package com.whe.log

import com.ggstar.util.ip.IpHelper

object IpUtil {

  def getCity(ip: String) =  {
    IpHelper.findRegionByIp(ip)
  }

  def main(args: Array[String]): Unit = {

    var a = 1
    var list = List(1, 2, 3, 4, 5)
    import scala.util.control._

    val loop = new Breaks
    loop.breakable {
      for (a <- list) {
        if (a == 3) {
          loop.break()
        }
      }
    }



  }



}

