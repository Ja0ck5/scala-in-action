package com.ja0ck5.programming.oop

import java.io.{File, PrintWriter}
import java.util.Date

/**
  * Created by Jack on 2018/2/27.
  */
object FileMatcher {

  private def filesHere = (new File(".")).listFiles

  def filesEnding(query: String): Unit = {
    //    for (file <- filesHere; if file.getName.endsWith(query))
    //      yield file

    //    filesMatching(query,_.endsWith(_))
    filesMatching(_.endsWith(query))

  }

  def filesContaining(query: String): Unit = {
    //    for (file <- filesHere; if file.getName.contains(query))
    //      yield file
    //    filesMatching(query,_.contains(_))
    filesMatching(_.contains(query))
  }

  def filesRegex(query: String): Unit = {
    //    for (file <- filesHere; if file.getName.matches(query))
    //      yield file

    //    filesMatching(query,_.matches(_))

    filesMatching(_.matches(query))
  }

  // 虽然不能把方法名当做值传递，但可以通过传递为你调用方法的函数值达到同样的效果
  //  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
  //    for (file <- filesHere; if matcher(file.getName, query))
  //      yield file
  //  }

  // 利用闭包来减少代码重复
  // 包含两个绑定变量, 下划线代表的参数 和 名为 query 的自由变量
  private def filesMatching(matcher: String => Boolean) =
  for (file <- filesHere; if matcher(file.getName))
    yield file


  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num < 0)
        exists = true
    exists
  }

  containsNeg(List(1, 2, 3, -4))

  // 不过更简洁的定义方式是对传入的 List 调用高阶函数 exists
  def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

  def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

  // 柯里化(curring)

  // 柯里化(curring) 的函数被应用于多个参数列表,而不是仅仅一个

  def plainOldSum(x: Int, y: Int) = x + y

  plainOldSum(1, 2)

  // 柯里化后的同一个函数，代之以一个列表的两个Int 参数
  def curriedSum(x: Int)(y: Int) = x + y

  //  curriedSum(1)
  // 实际上接连调用了两个传统函数。
  // 1. 第一个函数调用带单个名为 x 的 Int 参数，并返回第二个函数的函数值。
  // 2. 第二个函数带 Int 参数 y
  curriedSum(1)(2)

  // first 函数是指上执行了 curriedSum 的第一个传统函数调用会做的事情:
  def first(x: Int) = (y: Int) => x + y

  // 在 first 函数上应用 1 会产生第二个函数
  val second = first(1)

  println(second(2))

  // 可以用部分应用函数表达式方式
  val twoPlus = curriedSum(2) _
  println(twoPlus(2))

  //

  def twice(op: Double => Double, x: Double) = op(op(x))

  println(twice(_ + 1, 5))

  def withPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  // 这里的好处是由 withPrintWriter 来确认文件在末尾被关闭，而非用户代码，因此可以确保关闭文件。这个技巧被称为 借贷模式(loan pattern)
  // 因为 控制抽象函数，如withPrintWriter 打开了资源并 "贷出" 给函数。 PrintWriter 借给函数 op. 当函数完成的时候，它发出信号说明不再需要 "借" 的资源
  // 于是 资源被关闭在 finally 中,以确定被关闭
  withPrintWriter(new File("data.txt"), writer => writer.println(new Date()))

  // 让客户代码看上去更像内建控制结构的一种方式是 使用花括号代替小括号包围参数列表。Scala 的任何方法调用，如果只传入一个参数，就能可选地使用花括号代替小括号包围参数
  // 其目的是让客户程序员能写出包围在花括号内的函数字面量
  val g = "hello world"
  println(g.substring(7, 9))

  def withPrintWriter2(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  val testFile = new File("data.txt")
  withPrintWriter2(testFile) {
    writer => writer.println(new Date())
  }

  // 传名参数
  var assertionEnabled = true

  // 这个定义是正确的，但使用起来有点难看
  def myAssert(predicate: () => Boolean) =
    if (assertionEnabled && !predicate())
      throw new AssertionError

  // 其中不能缺少 () =>
  myAssert(() => 5 > 3)

  // 传名函数可以解决这个问题。要实现一个 传名函数,要定义参数的类型开始于 => 而不是 () =>
  def byNameAssert(predicate: => Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError

  byNameAssert(5 > 3)



}
