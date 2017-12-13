package com.ja0ck5.demo.advanced

/**
  * Created by Jack on 2017/12/8.
  */
class PairImplicit[T: Ordering](val f: T, val s: T) {
  // 隐式值，作用域内都可用
  def bigger(implicit ordered: Ordering[T]) = if (ordered.compare(f, s) > 0) f else s
}

/**
  * implicitly
  *
  * @param f
  * @param s
  * //  * @param ev$1
  * @tparam T
  */
class PairImplicitly[T: Ordering](val f: T, val s: T) {
  def bigger =
  // Predef method
    if (implicitly[Ordering[T]].compare(f, s) > 0) f else s
}

class PairImplicitlyOrdered[T: Ordering](val f: T, val s: T) {
  def bigger = {
    import Ordered._
    if (f > s) f else s
  }
}

object ContextBoundsInternals {
  def main(args: Array[String]): Unit = {
    println(new PairImplicit(7, 9).bigger)
    println(new PairImplicitly(7, 9).bigger)
    println(new PairImplicitlyOrdered(7, 9).bigger)
  }
}