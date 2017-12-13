package com.ja0ck5.demo.oop

import scala.reflect.ClassTag

class Triple[F, S, T](val first: F, val second: S, val third: T)

object TypeParameterize {
  def main(args: Array[String]): Unit = {
    val triple = new Triple("Spark", 3, 3.1415);
    val data = new Triple[String, String, Char]("Scala", "Spark", 'R');

    def getData[T](list: List[T]) = list(list.length / 2)

    println(getData(List("Scala", "Spark", 'R')))

    val f = getData[Int] _
    println(f(List(1, 2, 3, 4, 5, 6, 7, 8)))

    def buildArray[T: ClassTag](len: Int) = new Array[T](len)

    println(buildArray[Int](5).toList)

    def foo[A, B](f: A => List[A], b: A) = f(b)

  }
}
