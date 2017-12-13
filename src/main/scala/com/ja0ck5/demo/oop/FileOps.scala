package com.ja0ck5.demo.oop

import java.io.{File, PrintWriter}

import scala.io.Source

object FileOps {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("D:\\test.txt")
    for (line <- file.getLines()) {
      println(line)
    }
    file.close


    val webFile = Source.fromURL("http://spark.apache.org/")
    webFile.foreach(print)
    webFile.close()

    val writer = new PrintWriter((new File("scalaFile.txt")))
    for(i <- 1 to 100 ) writer.println(i)
    writer.close()

    print("Please enter your input : ")
    val line = Console.readLine
    println("Thanks,u just typed:" + line)
  }

}
