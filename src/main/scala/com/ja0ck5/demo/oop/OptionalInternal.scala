package com.ja0ck5.demo.oop

object OptionalInternal {

  def main(args: Array[String]): Unit = {
    val scores = Map("Alice" -> 27,"Spark"->100)

    scores.get("Alice") match{
      case Some(score) => println(score)
      case None => println("no score...")
    }



  }

}
