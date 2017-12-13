package com.ja0ck5.demo.hello

import scala.collection.mutable.ArrayBuffer

object ArrayOps {

  def main(args: Array[String]): Unit = {
    //    val array = Array(1, 2, 3, 4, 5)
    //    // loop
    //    for (i <- 0 until array.length) {
    //      println("array[" + i + "] : " + array(i))
    //    }
    //
    //    // for each
    //    for (elem <- array) {
    //      println(elem)
    //    }

    // 声明一个固定长度的数组
    //    val nums = new Array[Int](10)
    val a = new Array[String](10)
    for (i <- 0 until a.length) println(a(i))
    //    val s = Array("Hello", "World")
    //    s(0) = "GoodBye"
    //    println(s)

    // 变长数组
    //    val b = ArrayBuffer[Int]()
    //    b += 1
    //    b += (1, 2, 3, 5)
    //    b ++= Array(1, 3, 2, 5)
    //    b.trimEnd(5)
    //    b.insert(2, 6)
    //    b.insert(2, 7, 8, 9)
    //    b.remove(2)
    //    b.remove(2, 3)
    //    b.toArray


    val c = Array(2, 3, 5, 7, 11)
    val result = for (elem <- c) yield 2 * elem
    c.filter(_ % 2 == 0).map(2 * _)

    Array(1, 7, 2, 9).sum

    ArrayBuffer("Marry", "Json", "a", "Little", "Lamb").max

    val d = ArrayBuffer(1, 7, 2, 9)
    val dSorted = d.sorted

    val e = Array(1, 7, 2, 9)
    scala.util.Sorting.quickSort(e)

    e.mkString(" and ")
    a.mkString("<", ",", ">")

    val matrix = Array.ofDim[Double](3, 4)
    matrix(2)(1) = 42

    val triangle = new Array[Array[Int]](10)
    for (i <- 0 until triangle.length)
      triangle(i) = new Array[Int](i + 1)

  }
}
