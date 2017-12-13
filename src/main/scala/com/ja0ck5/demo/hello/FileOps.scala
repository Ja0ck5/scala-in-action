package com.ja0ck5.demo.hello

import scala.io.Source

object FileOps {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("D:\\test.txt")
    for (line <- file.getLines) {
      println(line)
    }

    val fileFromUrl = Source.fromURL("https://www.baidu.com/");
    for (line <- fileFromUrl.getLines()) {
      println(line)
    }
  }


}
