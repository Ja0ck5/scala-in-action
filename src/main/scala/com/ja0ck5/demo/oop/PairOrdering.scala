package com.ja0ck5.demo.oop

class PairOrdering[T: Ordering](val f: T, val s: T) {
  def max(implicit ordered: Ordering[T]) = {
    if (ordered.compare(f, s) > 0) f else s
  }
}

object PairOrdering {
  def main(args: Array[String]): Unit = {
    val po = new PairOrdering("Scala", "Hadoop")
    println(po.max)
    val po2 = new PairOrdering(1, 8)
    println(po2.max)
  }
}
