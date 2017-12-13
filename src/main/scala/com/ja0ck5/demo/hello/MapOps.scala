package com.ja0ck5.demo.hello

object MapOps {

  def main(args: Array[String]): Unit = {
    val ages = Map("John" -> 27, "Silver" -> 5)
    for ((k, v) <- ages) {
      println("k:" + k + ",v:" + v)
    }

    for ((k, _) <- ages) { //placeHolder
      println("the key is " + k)
    }

    val map = Map("Mac" -> 27, "Book" -> 15, "Silver" -> 5)
    for ((k, v) <- map) yield (k, v * 0.9)

    val scores = scala.collection.mutable.SortedMap("Mac" -> 27, "Book" -> 15, "Silver" -> 5)
    val bookScore = scores.getOrElse("Book", 0) // 有则直接返回key 对应的 value ,没有则返回 0

    scores += ("R" -> 9)
    scores -= ("Book")

    val imuScores = scala.collection.immutable.SortedMap("Mac" -> 27, "Book" -> 15, "Silver" -> 5)


  }

}
