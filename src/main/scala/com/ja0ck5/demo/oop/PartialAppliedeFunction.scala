package com.ja0ck5.demo.oop

object PartialAppliedeFunction {
  def main(args: Array[String]): Unit = {
    val data = List(1, 2, 3, 4, 5, 6)
    data.foreach(println)
    data.foreach(println _)
    data.foreach(x => println(x))

    def sum(a: Int, b: Int, c: Int) = a + b + c

    println("normal sum : " + sum(1, 2, 3))

    val fp_a = sum _
    println("fp_a:" + fp_a(1, 2, 3))
    println("fp_a.apply:" + fp_a.apply(1, 2, 3))

    val fp_b = sum(1, _: Int, 3)
    println("fp_b:" + fp_b(2))
    println("fp_b:" + fp_b(10))


  }


}
