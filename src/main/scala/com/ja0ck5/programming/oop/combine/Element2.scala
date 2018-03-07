package com.ja0ck5.programming.oop.combine

/**
  * Created by Jack on 2018/3/6.
  */
abstract class Element2 {

  /*final */def demo(): Unit ={
    println("Element's implementation invoked")
  }

}

class ArrayElement extends Element2{
  override def demo(): Unit = {
    println("ArrayElement 's implementation invoked")
  }
}

class LineElement extends Element2{
  override def demo(): Unit = {
    println("LineElement's implementation invoked")
  }
}

class  UniformElement extends Element2



