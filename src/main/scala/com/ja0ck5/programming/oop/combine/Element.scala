package com.ja0ck5.programming.oop.combine

/**
  * Created by Jack on 2018/3/3.
  */
abstract class Element {
  // 因为元素是二维的字符矩形,所以定义一个成员 contents 指向布局元素的内容
  def contents: Array[String]

  // 推荐的惯例是无论何时,只要方法中没有参数并且方法仅能通过读取所包含对象的属性去访问可变状态(特指方法不能改变可变状态),就使用无参数方法
  // 这个惯例支持统一访问原则(uniform access principle),就是说客户代码不应 由属性是通过字段实现还是方法实现而受影响
  def height: Int = contents.length

  // 由此我们可以更改 height 和 width 作为字段来实现
  // 两组定义从客户的观点来看是完全相同的。唯一的差别是访问字段比调用方法略快。
  //  val height: Int = contents.length
  //  val width: Int = if (height == 0) 0 else contents(0).length

  def width: Int = if (height == 0) 0 else contents(0).length

  // 原则上,Scala 的函数调用中可以省略所有的空括号。
  // 1 在调用方法超出其调用者对象的属性时,仍推荐写一对空括号。 例如方法执行了 IO 或写入可重新赋值的变量(var) 或读取不是调用者字段的 var
  // 2 总之无论是直接的还是非直接的使用可变对象,都应该添加空括号。
  // 3 这种方式是让参数列表扮演一个课件的线索来说明 调用出发了某些有趣的计算，如:
  "hello".length // 没有副作用,无需()
  println() // 最好别省略

  // 总之,Scala 鼓励使用将不带参数且没有副作用的方法定义为无参数方法的风格,即省略空括号
  // 但永远不要定义没有括号的带副作用的方法,因为那样 方法调用看上去会像在使用字段,所以你的客户会很奇怪为什么它带有副作用

  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element =
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString: String = contents mkString "\n"
}

object Element{
  def elem(contents:Array[String]):Element =
    new ArrayElement(contents)

//  def elem(chr:Char,width:Int,height:Int):Element=
//    new UniformElement(chr,width,height)

//  def elem(line:String):Element=
//    new LineElement(line)
}
