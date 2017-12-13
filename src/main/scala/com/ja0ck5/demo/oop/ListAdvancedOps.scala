package com.ja0ck5.demo.oop

object ListAdvancedOps {


  def main(args: Array[String]): Unit = {
    val bigData = List("Hadoop", "Spark");
    val data = List(1, 2, 3)

    val bigDataCore = "Hadoop" :: ("Spark" :: Nil)
    val dataInt = 1 :: 2 :: 3 :: Nil

    println("data is empty:" + data.isEmpty)
    println("head of data:" + data.head)
    println("data tail head:" + data.tail.head)

    val List(a, b) = bigData
    println("a:" + a + ",b:" + b)

    val x :: y :: rest = data
    println("x:" + x + ",y:" + y + ",rest" + rest)


    val shuffledData = List(6, 5, 2, 3, 1, 8, 6, 9)
    println("sorted list : "+sortList(shuffledData))

    def sortList(list: List[Int]): List[Int] = list match {
      case List() => List()
      case head :: tail => compute(head, sortList(tail))
    }

    def compute(data: Int, dataSet: List[Int]): scala.List[Int] = dataSet match {
      case List() => List(data)
      case head :: tail => if (data <= head) data :: dataSet
      else head :: compute(data, tail)
    }

  }
}
