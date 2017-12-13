package com.ja0ck5.demo.hello

import java.io.File

/**
  * Created by Jack on 2017/10/24.
  */
object ScalaBasics {

  def main(args: Array[String]) /*: Unit =*/ {
    //    println("This is a demo")
    // 测试 无参数函数
    //    doWhile()
    //    doWhile

    //    println(looper(10,20))

    //    var file = "scala.txt";
    //    if (!args.isEmpty) file = args(0)
    //    println("simple : " + file)
    //    file = if (!args.isEmpty) args(0) else "spark.xml"
    //    println("complex : " + file)


    // for loop
    //    for (i <- 1 to 10) {
    //      println("Number : " + i)
    //    }
    //
    //    for (i <- 1.to(10)) {
    //      println("1.To Number : " + i)
    //    }

    // for each
    //    var files = new File(".").listFiles()
    //    for (file <- files) {
    //      println("file name : " + file.getName)
    //      println("file : " + file)
    //    }

    // Exception
    var n = 99
    var file = "something.txt"
    // openFile(file)
    try {
      val half = if (n % 2 == 0) n / 2 else throw
        new RuntimeException("N must be even")
    } catch {
      case e: Exception => println("the exception is : " + e.getMessage)
    } finally {
      // close resources
      // close(file)
    }


  }

  /**
    *
    * 没有参数的函数
    */
  def doWhile(): Unit = {
    // 声明变量
    var line = ""
    //    val line = "" 常量
    do {
      line = readLine()
      println("Read:" + line)
    } while (line != "")
  }


  // 因为 object 里面所有的内容都是静态的,main 方法没有运行，也会被调用
  //  var line = ""
  //  //    val line = "" 常量
  //  do {
  //    line = readLine()
  //    println("Read:" + line)
  //  } while (line != "")

  /**
    * 多个参数，并返回 Long
    *
    * @param x
    * @param y
    * @return
    */
  def looper(x: Long, y: Long): Long = {
    var a = x;
    var b = y;
    while (0 != a) {
      var temp = a
      a = b % a
      b = temp
    }
    b
  }

}
