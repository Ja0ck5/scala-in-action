package com.ja0ck5.demo.oop

class A[T]

class B[T]

object MultipleBounds {

  def main(args: Array[String]): Unit = {
    implicit val a = new A[Int]
    implicit val b = new B[Int]

    def foo[T: A : B](i: T) = println("OK")

    foo(2)
  }

}
