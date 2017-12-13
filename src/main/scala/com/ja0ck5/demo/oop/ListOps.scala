package com.ja0ck5.demo.oop

object ListOps {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("partition:")
    println(list partition (_ % 2 == 0))
    println("find:")
    println(list find (_ % 2 == 0))
    println("find <= 0 :")
    println(list find (_ <= 0))
    println("takeWhile <4 :")
    println(list takeWhile (_ < 4))
    println("dropWhile <4 :")
    println(list dropWhile (_ < 4))
    println("span <4 :")
    println(list span (_ < 4))


    def hastotallyZeroRow(m: List[List[Int]]) = m exists (row => row forall (_ == 0))

    val m = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 0))
    println("hastotallyZeroRow:" + hastotallyZeroRow(m))


    // foldLeft
    println((1 to 100).foldLeft(0)(_ + _))
    println((0 /: (1 to 100)) (_ + _))

    // foldRight
    println((1 to 5).foldRight(100)(_ - _))
    println(((1 to 5) :\ 100) (_ - _))

    println(List(1, -3, 4, 2, 6) sortWith (_ < _))
    println(List(1, -3, 4, 2, 6) sortWith (_ > _))
    println(List(1, -3, 4, 2, 6) sortWith (_ <= _))

  }

}
