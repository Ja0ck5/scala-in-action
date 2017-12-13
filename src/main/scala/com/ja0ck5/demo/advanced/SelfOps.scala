package com.ja0ck5.demo.advanced

class SelfOps {
  self =>
  val tmp = "Scala"

  def foo = self.tmp + ": this.tmp=" + this.tmp
}

trait S1

class S2 {
  this: S1 =>
}

class S3 extends S2 with S1

trait T {
  this: S1 =>
}

object S4 extends T with S1

object SelfTypes {
  def main(args: Array[String]): Unit = {
    class Outer {
      outer =>
      val s1 = "Spark"

      class Inner {
        println(outer.s1)
      }

    }
    val c = new S2 with S1
  }
}
