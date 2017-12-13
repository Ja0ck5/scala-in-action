package com.ja0ck5.demo.oop

object OopInScala {

  def main(args: Array[String]): Unit = {
    val o1 = new Outer("Spark")
    val o2 = new Outer("Hadoop")

    val i1 = new o1.Inner("Scala")
    val i2 = new o2.Inner("Java")

    i1.foo(i1)
    i2.foo(i2)

  }

}

class Outer(val name : String ){ outer =>
  class Inner(val name : String){
    def foo(b : Inner) = println("Outer:" + outer.name +";\r\nInner:" + b.name)
  }

}
