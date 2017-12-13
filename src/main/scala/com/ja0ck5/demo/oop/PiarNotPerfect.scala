package com.ja0ck5.demo.oop

class PairNotPerfect[T <% Comparable[T]](val f: T, val s: T) {
  def max = if (f.compareTo(s) > 0) f else s
}

object PairNotPerfect {
  def main(args: Array[String]): Unit = {
    val p1 = new PairNotPerfect("Spark", "Hadoop");
    println(p1.max)
    val p2 = new PairNotPerfect(3, 5);
    println(p2.max)

    val pb1 = new PairBetter("Spark","Hadoop")
    println(pb1.max)
    val pb2 = new PairBetter(3, 5);
    println(pb2.max)
  }
}

class PairBetter[T <% Ordered[T]](val f: T,val s:T){
  def max = if(f > s) f else s
}
