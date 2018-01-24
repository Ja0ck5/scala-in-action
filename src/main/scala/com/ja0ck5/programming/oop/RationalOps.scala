package com.ja0ck5.programming.oop

/**
  * 每个有理数都能被表示成 Rational 对象。当两个 Rational 对象相加时，将创建新的带着累加结果的 Rational 对象
  * Created by Jack on 2018/1/18.
  */
object RationalOps {

  def main(args: Array[String]): Unit = {
    val oneHalf = new Rational(1, 2)
    println(oneHalf)
    val threeY = new Rational(3)
    println(threeY)
  }


}

/**
  * 创建 Rational
  * n : numerator
  * d : denominator
  *  1. 如果累没有主体，就不需要指定一对空的花括号。
  * Scala 编译器会收集这两个类参数并创造出带同样的两个参数的主构造器
  *
  * 2.不可变对象的权衡
  * 不可变对象提供了若干强于可变对象的有点和一个潜在的缺点。
  *     2.1 不可变对象比可变对象更容易沥青头绪，因为没有随着时间变化的复杂的状态空间
  *     2.2 可以很自由地传递不可变对象，但对于可变对象来说，传递给其他代码之前，需要先建造个以防万一的副本
  *     2.3 一旦不可变对象完成构造之后，就不会有线程因为并发访问而破坏对象的内部状态，因为根本没有线程可以
  * 改变不可变对象的状态
  *     2.4 不可变对象 让 哈希表 键值更安全
  *     2.5 不可变对象唯一的缺点是 有时需要复制很大的对象表 而可变对象的更新可以在原址发生。有些情况下会变得难以
  * 快速地完成 而可能产生性能瓶颈。因此，要求功能库提供不可变类的可变版本也不是一件稀奇的事情。
  *
  * 面向对象编程的优点之一就是它允许你把数据封装在对象之内以确保数据再整个生命周期中的有效性
  * 不可变对象，意味着必须确保对象创建时数据的有效性。
  */
class Rational(n: Int, d: Int) {
  // 定义检查先决条件
  // 如果传入的值为 true 则 正常返回,否则 抛出 IllegalArgumentException 阻止对象被构造
  require(d != 0)

  // 使用 n 和 d 初始化
  val number: Int = n
  val denom: Int = d

  // 辅助构造器(auxiliary constructor)
  def this(n: Int) = this(n, 1)

  override def toString: String = number + "/" + denom

  // 不能把传入的有理数加到自己身上，而是必须创建并返回全新的 Rational 累加值
  // 尽管类参数 n 和 d 都在 add 代码可引用的范围内，但是 add 方法仅能访问调用对象自身的值。
  //  def add(that: Rational): Rational = new Rational(n * that.d + that.n * d, d * that.d)

  def add(that: Rational): Rational = new Rational(number * that.denom + that.number * denom, denom * that.denom)

  def lessThan(that: Rational) = this.number * that.denom < that.number * this.denom

  def max(that: Rational) = if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int = if (0 == b) a else gcd(b, a % b)

  def +(that: Rational): Rational = new Rational(number * that.denom + that.number * denom, denom * that.denom)

  // 重载
  def +(i: Int): Rational = new Rational(number + i * denom, denom)

  def -(that: Rational): Rational = new Rational(number * that.denom - that.number * denom, denom * that.denom)

  // 重载
  def -(i: Int): Rational = new Rational(number - i * denom, denom)

  def *(that: Rational): Rational = new Rational(number * that.number, denom * that.denom)

  def *(i: Int): Rational = new Rational(number * i, denom)

  def /(that: Rational): Rational = new Rational(number * that.denom, denom * that.number)

  def /(i: Int): Rational = new Rational(number, denom * i)

  // 现在可以 r*2 ，但是还不可以 2 * r 。因为 Int 类没有带 Rational 参数的乘法
  // Scala 中可以创建再需要的时候自动把整数转换为有理数的隐式转换。
  // 定义了 从 Int 到 Rational 的转换方法。 implicit 修饰符告诉编译器再一些情况下自动调用
  // 隐式转换需要在定义范围内才起作用。
  implicit def int2Rational(x:Int) = new Rational(x)
  val r = new Rational(2,3)
  val implicitR = 2 * r



}


