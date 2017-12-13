package com.ja0ck5.demo.advanced

/**
  * Created by Jack on 2017/12/11.
  */
abstract class Template[A] {
  def add(x: A, y: A): A
}

abstract class SubTemplate[A] extends Template[A] {
  def unit: A
}

object ImplicitObject {

  def main(args: Array[String]): Unit = {
    implicit object StringAdd extends SubTemplate[String] {
      override def unit: String = ""

      override def add(x: String, y: String): String = x concat y
    }

    implicit object IntAdd extends SubTemplate[Int] {
      override def unit: Int = 0

      override def add(x: Int, y: Int): Int = x + y
    }

    def sum[A](xs: List[A])(implicit m: SubTemplate[A]): A =
      if (xs.isEmpty) m.unit
      else m.add(xs.head, sum(xs.tail))

    println(sum(List(1,2,3,4)))
    println(sum(List("a","b","c","d")))
  }

}