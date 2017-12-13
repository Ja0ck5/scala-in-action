package com.ja0ck5.demo.oop

object PatternMatch {

  def main(args: Array[String]): Unit = {
    val data = 30
    data match {
      case 1 => println("First")
      case 2 => println("Second")
      case _ => println("Not Known Number")
    }

    val result = data match {
      case i if i == 1 => "The First"
      case number if number == 2 => "The Second"
      case _ => "Not Known Number"
    }
    println(result)

    "Spark !" foreach{c => println(
        c match {
          case ' ' => "space"
          case ch => "Char:" + ch
        }
    )}
  }

}
