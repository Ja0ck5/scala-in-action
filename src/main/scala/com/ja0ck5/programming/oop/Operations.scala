package com.ja0ck5.programming.oop

/**
  *
  * Scala 操作符实际只是普通方法调用的另一种表现形式
  *
  *
  * Created by Jack on 2018/1/17.
  */
object Operations {

  def main(args: Array[String]): Unit = {
    val sum = 1 + 2
    // 与此是同一回事,Int 类 包含了一个 + 的方法,它传入一个 Int 参数 并返回一个 Int 结果，在两个 Int 值相加时被调用
    // 实际上, Int 包含了 + 的各种类型参数的重载方法.
    // 符号 + 是操作符,更明确地说,是中缀操作符。操作符标注不仅限于像 + 这种看上去像操作符的东西.
    val sum2 = 1.+(2)
    val sumLong = 1.+(2L)
    // 任何方法都可以被当做操作符来标注
    val s = "Hello Scala"
    val idx = s indexOf 'o'
    // 前缀操作符 中缀操作符 后缀操作符 都是一元的:它们仅有一个操作数。
    val prefixMinus = -2.0
    // Scala 会把表达式 -2.0 转换成方法调用
    // 标识符当中能作为前缀操作符用的只有 + - ! ~
    val minus = (2.0).unary_-
    // 后缀操作符 是不用点或括号调用的不带任何参数的方法。在 Scala 中，方法调用的空括号可以省略，惯例是如果方法带有其他作用，则加上括号。没有，则去掉括号
    // 括号有副作用
    println()
    // 无副作用
    val lowerCaseStr = s.toLowerCase

    println(List(1,2,3) == List(1,2,3))// true

  }

}
