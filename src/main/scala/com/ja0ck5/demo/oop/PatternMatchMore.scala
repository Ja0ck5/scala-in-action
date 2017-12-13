package com.ja0ck5.demo.oop

object PatternMatchMore {

  def main(args: Array[String]): Unit = {
    def match_type(t: Any) = t match {
      case p: Int => println("It is an Integer")
      case p: String => println("It is an String")
      case m: Map[_, _] => m.foreach(println)
      case _ => println("Unknown type!!~!")
    }

    match_type(2)
    match_type(Map("Scala" -> "Spark"))

    def match_array(arr: Any) = arr match {
      case Array(0) => println("Array 0")
      case Array(x, y) => println("Array(x,y)" + x + ":" + y)
      case Array(0, _*) => println("Array0 ...")
      case _ => println("something else")
    }

    match_array(Array(0))
    match_array(Array(0, 1))
    match_array(Array(0, 1, 2, 3, 4, 5))

    def match_list(list: Any) = list match {
      case 0 :: Nil => println("List 0")
      case x :: y :: Nil => println("List(x,y)" + x + ":" + y)
      case 0 :: tail => println("Array0 ...")
      case _ => println("something else")
    }


    match_list(List(0))
    match_list(List(0, 1))
    match_list(List(0, 1, 2, 3, 4, 5))

    def match_tuple(tuple: Any) = tuple match {
      case (0, _) => println("Tuple 0")
      case (x, 0) => println("Tuple" + x)
      case _ => println("something else")
    }

    match_tuple((0, "Scala"))
    match_tuple((2, 0))
    match_tuple((0, 1, 2, 3, 4, 5))

    val pattern = "([0-9]+) ([a-z]+)".r
    "20171106 hadoop" match {
      case pattern(num, item) => println("num:" + num + ",item:" + item)
    }


  }

}
