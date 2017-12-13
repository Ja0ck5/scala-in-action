package com.ja0ck5.demo.oop

object ListOneOrderOps {

  def main(args: Array[String]): Unit = {
    println(List(1,2,3):::List(5,6,7,8):::List(9,10,11))
    println(List(1,2,3,4).length)

    val bigData = List("Hadoop","Spark","Scala")
    println("bigData:"+bigData)
    println("last:"+bigData.last)
    println("init:"+bigData.init)
    println("inits:"+bigData.inits)
    println("reverse:"+bigData.reverse)
    println("take 2 :"+bigData take 2)
    println("take(2) :"+bigData.take(2))
    println("drop 2  :"+bigData drop 2 )
    println("split at 2  :"+bigData splitAt  2 )
    println("aplly 2  :"+bigData apply 2 )

    val data = List('a','b','c','d','e','f')
    println("indices:" + data.indices)
    println("indices zip data:" + data.indices zip data)
    println("zipWithIndex:" + data.zipWithIndex)
    println("data:" + data.toString())
    println("data mkString1:" + data.mkString("[",",","]"))
    println("data mkString2:" + data.mkString("  "))
    println("data mkString3:" + data.mkString)


  }
}
