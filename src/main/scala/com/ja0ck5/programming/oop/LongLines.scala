package com.ja0ck5.programming.oop


import scala.io.Source

/**
  * Created by Jack on 2018/2/1.
  *
  * Scala 的函数式头等函数(first-class function).
  * 不仅可以定义和调用函数，还可以写成匿名的字面量(literal).并把它们作为值(value)来传递
  *
  * 函数字面量被编译进类，并在运行期实例化为函数值(function value).
  *
  * 因此函数字面量和值的区别:
  * 函数字面量存于源代码
  * 函数值作为对象存在运行期
  * 这个区别很像类(源代码) 和对象(运行期)之间的关系
  *
  * 任何函数值都是某个扩展了 Scala 包的若干 FunctionN 特质之一的类的实例。
  * 如 Function0 是没有参数的函数
  * Function1 是有一个参数的函数。 每个 FunctionN 特质有一个 apply 方法来调用函数。
  *
  */
object LongLines {

  def processLine(filename: String, width: Int, line: String): Unit = {
    if (line.length > width)
      println(filename + ":" + line.trim)
  }

  def processFile(filename: String, width: Int): Unit = {
    // filename: String, width: Int 参数并不是必须的，也可以直接使用外部环境的参数
    //    def processFile(line: String): Unit = {
    def processFile(filename: String, width: Int, line: String): Unit = {
      if (line.length > width)
        println(filename + ":" + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(filename, width, line)
  }


  def main(args: Array[String]): Unit = {
    //  => 指明这个函数把左边的东西(x:Int)[即任何整数 x ] 转变 成 右边的东西(x+1).
    // 函数值是对象,所以可以存入 变量. 同时也是函数，所以可以同一般的函数调用写法来调用
    var increase = (x: Int) => x + 1
    var result = increase(10)
    println(result)

    // 因为 increase 是 var
    increase = (x: Int) => x + 9999
    println(increase(10))

    increase = (x: Int) => {
      println("We")
      println("are")
      println("champion")
      x + 1
    }

    println(increase(10))

    // foreach
    val nos = List(-11, -10, -5, 0, 5, 10, 11)
    nos.foreach((x: Int) => println(x))


    println(nos.filter((x: Int) => x > 0))
    // 函数字面量的短格式
    println(nos.filter((x) => x > 0)) // Scala 编译器知道 x 一定是整数，因为看到你立刻使用了这个函数过滤整数列表。这个称为 目标类型化(target typing)
    println(nos.filter(x => x > 0))

    // 占位符语法
    // 如果想让函数字面量更简洁，可以把下划线当作一个或更多参数的占位符，只要每个参数再函数字面量内仅出现一次。
    println(nos.filter(_ > 0))

    // _ + _ 扩展成带两个参数的函数字面量。这样也解释了为何仅当每个参数在函数字面量中最多出现一次时，才能使用短格式。
    val f = (_: Int) + (_: Int)
    println(f(5,10))



  }

}
