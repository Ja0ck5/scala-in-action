package com.ja0ck5.demo.oop

object ListHighOrderFunOps {

  def main(args: Array[String]): Unit = {
    println(List(1, 2, 3, 4, 5, 6) map (_ + 1))

    val data = List("Spark", "HGahahaha", "Hadoop", "Scala")
    println(data map (_.length))
    println(data map (_.toList.reverse.mkString))

    //List(List(S, p, a, r, k), List(H, G, a, h, a, h, a, h, a), List(H, a, d, o, o, p), List(S, c, a, l, a))
    println(data map (_.toList))
    //List(S, p, a, r, k, H, G, a, h, a, h, a, h, a, H, a, d, o, o, p, S, c, a, l, a)
    println(data flatMap (_.toList))
    //List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,3), (6,4), (6,5), (7,1), (7,2), (7,3), (7,4), (7,5), (7,6), (8,1), (8,2), (8,3), (8,4), (8,5), (8,6), (8,7), (9,1), (9,2), (9,3), (9,4), (9,5), (9,6), (9,7), (9,8))
    println(List.range(1, 10) flatMap (i => List.range(1, i) map (j => (i, j))))

    var sum = 0
    List(1, 2, 3, 4, 5) foreach (sum += _)
    println(sum)

    println(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) filter (_ % 2 == 0))
    println(data filter (_.length == 5))


  }

}
