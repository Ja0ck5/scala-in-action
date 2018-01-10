package com.ja0ck5.programming.oop

/**
  * Created by Jack on 2017/12/18.
  */
class ChecksumAccumulator {
  // public 是 Scala 的 默认访问级别
  private var sum = 0;

  /**
    * Scala 里的方法参数的一个重要特征是 都是 val , 不是 var
    * val 更易于理清头绪。不需要分析更多的代码，已确定是否 val 被重新赋值
    *
    * @param b
    */
  def add(b: Byte): Unit = {
    //    b += 1 编译错误
    sum += b
  }

  def checkSum(): Int = {
    return ~(sum & 0xFF) + 1
  }

  /**
    * 如果去掉 方法体 前面的 等号，那么方法的结果类型就必定是 Unit
    * Scala 编译器可以把任何类型转换为 unit
    * 如果方法的最后结果为 String
    * 但是 结果类型被声明为 unit
    * 那么 String 将被转为 Unit 并丢弃原值
    *
    * @param b
    */
  def add2(b: Byte) {
    sum += b
  }

  def checkSum2(): Int = ~(sum & 0xFF) + 1

  /**
    * 声明了结果类型为 Unit,因此 String 被转变为 Unit.
    * 也就是说，带有花括号但没有等号的，本质上被当做 Unit 结果类型的方法
    *
    * 因此，对于想反悔 非Unit 值得方法，却忘记加 等号 时，错误就出现了
    * 所以，为了得到想要的结果，等号是必不可少的
    *
    */
  def f(): Unit = "This String gets lost"

  def g() {
    "This String gets lost too"
  }

  /**
    * 分号推断规则
    *
    * 以下情况的一种成立,否则行尾被认为是一个分号
    * 1. 疑问行 有一个不能合法作为语句结尾的字结束，如句点或中缀操作符
    * 2. 下一行开始于 不能作为语句开始的词
    * 3. 行结束语括号(...) 或 [...] 内部，因为这些符号不可能容纳多个语句
    *
    * @return
    */
  def h() = {

    // 分号推断，语句末尾的分号通常是可选的。但是，如果一行包含多条语句的时候，分号是必须的
    val s = "hello";
    println(s)
    val x = 1
    if (x < 2)
      println("too small")
    else
      println("ok")

    // 但是一下情况会被拆成两部分
    //    x
    //    +y
    // 放到kuo括号里面,会被当成一部分,这是理所当然的
    val y = 0
    val r = (x
      + y)
    println(r)
    // 或者把操作符 + 放在行末 .也正因此，串接类似于 + 这样的中缀操作符的时候,Scala 通常的风格是把操作符放在行尾，而不是行头
    var z = 0
    x +
      y +
      z

    "This String gets lost too"
  }


}
