package com.ja0ck5.programming.oop

import scala.io.Source

/**
  * Created by Jack on 2018/2/1.
  */
object LongLines {

  def processLine(filename: String, width: Int, line: String): Unit = {
    if (line.length > width)
      println(filename + ":" + line.trim)
  }

  def processFile(filename: String, width: Int): Unit = {
    // filename: String, width: Int 参数并不是必须的，也可以直接使用外部环境的参数
//    def processFile(line: String): Unit = {
    def processFile(filename: String, width: Int, line: String): Unit = {
      if (line.length > width)
        println(filename + ":" + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(filename, width, line)
  }

}
