package com.ja0ck5.demo.hello

import scala.io.Source

object LazyOps {

  def main(args: Array[String]): Unit = {
    lazy val file = Source.fromFile("D:\\nonExist.txt")
    println("Scala......")
    for (line <- file.getLines) println(line)  // 到使用时才执行
  }

}
