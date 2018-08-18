package com.whe.log

import java.text.SimpleDateFormat
import java.util.{Date, Locale}

import org.apache.commons.lang3.time.FastDateFormat

object DateUtils {

  val E_DATE_FORMAT = FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH)

  val C_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")

  def getTime(time: String) = {
    try {
      E_DATE_FORMAT.parse(time.substring(time.indexOf("[") + 1, time.lastIndexOf("]"))).getTime

    } catch {
      case e : Exception => {
        0l;
      }
    }
  }


  def parse(time: String) = {
    C_DATE_FORMAT.format(new Date(getTime(time)))
  }

}
