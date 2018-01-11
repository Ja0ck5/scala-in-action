package com.ja0ck5.programming.oop

import scala.collection.mutable.Map

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

/**
  * Scala 比 Java 更为面向对象的特点之一是 Scala 不能定义静态成员,而是定义单例对象。除了用 object 关键字替换了 class 关键字以为
  * 单例对象的定义看上去与类定义一直
  *
  * 当单例对象与某个类共享同一个名称时，该单例对象被称为这个类的 伴生对象(companion object).
  * 类和它的伴生对象必须定义在一个源文件里面
  * 类被称为该单例对象的伴生类(companion class)。
  * 类与其伴生对象可以互相访问其私有成员
  *
  * 单例对象类似于 Java 中的 静态方法工具类
  * 但是该单例对象不只是静态方法的工具类。它同样是头等对象。
  *
  * 这里的例子，只有遇到了 缓存能解决的性能问题时，才用得到
  * 而且应该使用 弱映射
  * 如 scala.Collection.jcl 的 WeakHashMap 如果内存稀缺的话，缓存里的条目就会被垃圾回收机制回收掉
  *
  * 此外 new 只能用于实例化类，因此创造的新对象是 类ChecksumAccumulator 而不是同名的单例对象
  *
  *
  * 定义单例对象并没有定义类型
  * 如果只有 ChecksumAccumulator 对象的定义，就不能建立 ChecksumAccumulator 类型的变量。
  * 或者认为 ChecksumAccumulator 类型是由单例对象的伴生类定义的。
  * 然而 单例对象扩展了父类，并可以混入特质(Trait) 因此，可以使用类型调用单例对象的方法 或者 用类型的实例变量指代单例对象
  * 并把它传递给需要类型参数的方法
  *
  *
  * 类和单例对象 的区别
  * 1. 单例对象不带参数，而类可以。这里是因为单例对象不是用 new 关键字实例化的，所以没机会传递实例化参数
  * 2. 每个 单例对象 都被实现为 虚构类(synthetic class) 的实例，并指向静态的变量，因此 单例对象与 Java 静态类有着相同的初始化语义
  * 3. 单例对象 在第一次被访问的时候才会被初始化
  * 4. 不与伴生类共享名称的单例对象被称作 独立对象(standalone object)。可以用于工具类，或者定义 Scala 应用的入口
  *
  * 虚构类的名字是对象名加上一个 $ 如 单例对象ChecksumAccumulator 的虚构类为 ChecksumAccumulator$
  *
  */
object ChecksumAccumulator {

  private val cache = Map[String, Int]()

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s -> cs) // 建立传入字符串到整数校验和的键值对映射 然后加入 cache Map 中
      cs
    }

  /**
    * Scala 的每个源文件都隐含了对包 java.lang/ 包 scala, 以及单例对象 Predef 的成员引用
    * 包 scala 中的 Predef 对象包含了许多有用的方法 如 println assert
    *
    *
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val str = "test"
    val strMap = Map[String, Int]()
    val i = 10;
    println(strMap += (str -> i))

    ChecksumAccumulator.calculate("Every value is an object")
  }

}
