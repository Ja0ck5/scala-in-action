package com.ja0ck5.demo.hello

/**
  * 元组
  */
object TupleOps {

  def main(args: Array[String]): Unit = {
    var triple = (100, "Spark", "Hadoop") // Scala 类型推断
    println(triple._1)
    println(triple._2)

    val tuple = (1,1,2,3.14,9,"Spark","Hadoop","Scala")

    val forth = tuple._4
    val forthWithoutPoint = tuple _4

    val (first,second,third,fortha,fifth,sixth,seventh,eighth) = tuple

    val (f,sec,_,_,_,_,_,_) = tuple

    "Scala Spark".partition(_.isUpper)

    // zip
    val symbol = Array("[", "-", "]")
    val counts = Array(1, 5, 1)// 对应的符号打印次数
    val pair = symbol.zip(counts)
    for ((x, y) <- pair) Console.println(x * y)

  }

}
