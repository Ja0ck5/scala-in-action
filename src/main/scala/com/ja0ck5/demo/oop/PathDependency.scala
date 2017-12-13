package com.ja0ck5.demo.oop

class PDOuter {
  private val x = 10

  class PDInner {
    private val y = x + 10
  }

}

object PathDependency {
  def main(args: Array[String]): Unit = {
    val o = new PDOuter
    val inner = new o.PDInner
    val inner2: o.PDInner = new o.PDInner

    val o1 = new PDOuter
    val o2 = new PDOuter

    //    val i: o2.PDInner = new o1.PDInner
    val i: PDOuter#PDInner = new o1.PDInner
  }
}
