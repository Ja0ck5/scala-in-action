package com.ja0ck5.demo.advanced

object ImplicitConversionWithImplicitParams {

  def main(args: Array[String]): Unit = {
    def bigger[T](a:T,  b:T)(implicit ordered: T => Ordered[T])
      = if (ordered(a) > b) a else b
    println(bigger(3,4))
    println(bigger("Spark","Hadoop"))

  }

}
