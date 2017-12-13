package com.ja0ck5.demo.advanced

/**
  * Created by Jack on 2017/12/2.
  */

class InfixType[A, B]


object InfixType {

  def main(args: Array[String]): Unit = {
    "Hadoop" >>: "Spark" >>: Log

    val list = List()
    val newList = "A" :: "B" :: list
    println(newList)


    val infix: Int InfixType String = null
    val infix1: InfixType[Int, String] = null

    case class Cons(f: String, s: String)
    val caseClass = Cons("one", "two")

    caseClass match {
      case "one" Cons "two" => println("Spark!!!Two") // 使用了 unapply
    }

  }

}

object Log {
  // 右结合的
  def >>:(data: String): Log.type = {
    println(data);
    Log
  }

}
