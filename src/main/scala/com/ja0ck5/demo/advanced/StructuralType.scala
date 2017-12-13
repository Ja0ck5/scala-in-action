package com.ja0ck5.demo.advanced

class Structural {
  def open() = {
    println("A class instanced open!!!")
  }
}

object StructuralType {

  def main(args: Array[String]): Unit = {
    init(new {
      def open() = println("a new open method")
    })
    type X = {def open(): Unit}

    def init(res: X) = res.open()

    init(new {
      def open() = println("a new opened method open again")
    })

    object A {
      def open() {
        println("A single object open")
      }
    }
    init(A)

    val structural = new Structural
    init(structural)

  }

  // 只要传进的方法为 open() 就执行
  def init(res: {def open(): Unit}) {
    res.open
  }
}
