package com.ja0ck5.demo.oop

import java.lang.Math._
object HighOrderFunction {

  def main(args: Array[String]): Unit = {
    (1 to 9).map("*" * _).foreach(println)
    (1 to 9).filter(_ % 2 == 0).foreach(println)

    println((1 to 9).reduceLeft(_ * _))

    "Spark is the most exciting thing happening in big data today".split(" ").sortWith(_.length < _.length).foreach(println)

    val fun = ceil _
    val num = 3.14
    println(fun(num))
    Array(3.14,1.42,2.0).map(fun).foreach(println)

    val triple = (x:Double) => 3 * x
    Array(3.14,1.42,2.0).map(triple)
    Array(3.14,1.42,2.0).map((x:Double) => 3* x)
    Array(3.14,1.42,2.0).map{(x:Double) => 3* x}

    def highOrderFunction(f:(Double) => Double) = f(0.25)
    println(highOrderFunction(ceil _))
    println(highOrderFunction(sqrt _))

    def mulby(factor : Double) = (x:Double) => x * factor
    val quituple = mulby(5)
    println(quituple(20))

    println(highOrderFunction((x:Double) => 3 * x))
    highOrderFunction((x) => 3*x)
    highOrderFunction(x => 3*x)
    highOrderFunction(3*_)
    val fun2 = 3 * (_ : Double)
    val fun3: Double => Double = 3 * _


  }

}
