package com.ja0ck5.demo.oop

class Pair[T <: Comparable[T]](val first: T, val second: T) {
  def max = if (first.compareTo(second) > 0) first else second
}

class PairLowerBound[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new PairLowerBound[R](newFirst, second)
}

object TypeVariablesBounds{
  def main(args: Array[String]): Unit = {
    val pair = new Pair("Spark","Hadoop")
    println(pair.max)
  }
}