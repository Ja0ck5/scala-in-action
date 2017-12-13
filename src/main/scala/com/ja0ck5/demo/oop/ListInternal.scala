package com.ja0ck5.demo.oop

object ListInternal {

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    val listAny : List[Any] = list
    println(list.isEmpty)
    println(list.head)
    println(list.tail)
    println(list.length)
    println(list.drop(2))
    println(list.map(_*2))




  }

}
