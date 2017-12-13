package com.ja0ck5.demo.oop

import scala.collection.mutable

class DynamicCollectionOps {

}

object DynamicCollectionOps {
  def main(args: Array[String]): Unit = {
    val data = mutable.Set.empty[Int]
    data ++= List(1, 2, 3)
    println(data)
    data += 4
    println(data)
    data --= List(2, 3)
    println(data)
    data += 1
    println(data)
    data.clear()
    println(data)

    println("================ map ==================")
    val map = mutable.Map.empty[String,String]
    map("java") = "Hadoop"
    map("scala") = "Spark"
    println(map)
    println(map("scala"))

    println("================ treeSet ==================")
    val treeSet = mutable.TreeSet(9,0,6,1,3,5,2,4,8,7)
    println(treeSet)
    val treeSetStr = mutable.TreeSet("java","Spark","Scala","Hadoop")
    println(treeSetStr)
    println("================ treeMap ==================")
    val treeMap = mutable.TreeMap("Scala" -> "Spark","Java" -> "Hadoop")
    println(treeMap)

  }
}
