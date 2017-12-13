package com.ja0ck5.demo.oop

/**
  * Created by Jack on 2017/10/26.
  */
object ApplyOps {

  def main(args: Array[String]): Unit = {
    val array = Array(1, 5, 9)
    val at = new ApplyTest
    at.haveATry
    println(at())
    val a = ApplyTest()
    a.haveATry
  }


}

class ApplyTest {
  def apply() = println("I am into Scala so much!!!")

  def haveATry {
    println("Have a try on apply!")
  }
}

object ApplyTest {
  //  def apply: ApplyTest = new ApplyTest()
  def apply() = {
    println("object ApplyTest....")
    new ApplyTest
  }
}
