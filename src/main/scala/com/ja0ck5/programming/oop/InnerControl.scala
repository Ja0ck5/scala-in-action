package com.ja0ck5.programming.oop

import java.io.File

import scala.io.Source

/**
  * Scala 的内建控制结构
  * Created by Jack on 2018/1/25.
  */
object InnerControl {

  def main(args: Array[String]): Unit = {

    // if
    var filename = "default.txt"
    if (!args.isEmpty)
      filename = args(0)

    // Scala 的 if 是能返回值的表达式
    // 1. 不过实际优点是在于 使用了 val 而不是 var 。 val 体现了函数式的风格，并且具有与 java 的final 变量类似的效果
    // val 可以告诉读者，代码变量将不再改变，从而节省了他们审查变量作用域的所有代码，已检查它是否改变的工作
    // 2. 使用 val 而不是 var 能更好地支持 等效推论(equational reasoning). 在表达式没有副作用的前提下，引入的变量等效于它的表达式
    filename = if (!args.isEmpty)
      args(0) else "default.txt"
    // 因此，无论何时都可以用表达式替代变量名
    println(if (!args.isEmpty) args(0) else "default.txt")
    // val 有助于安全的执行这类重构以不断革新代码


    // while 和 do-while 结构之所以被称之为 循环， 而不是表达式，是因为它们不能产生有意义的结果，结果的类型是 Unit,
    // 是表明存在并且唯一存在的类型为 Unit 值，称为 unit value, 写成 () . () 的存在是 Scala 的 Unit 不同于 Java 的 void 的地方。
    println(greet() == ()) // true
    // 建议在代码中更为审慎地使用 while 和 od-while ，因为没有非用不可的理由，可以尝试别的方式实现同样的功能
    var line = ""
    //    while ((line = readLine()) != "") // 不起作用
    //      println("Read:" + line)

    // For 对于任何种类的集合类都有效
    val filesHere = new File(".").listFiles()
    for (file <- filesHere)
      println(file)

    for (i <- 1 to 4)
      println(i)

    println("==============")

    for (i <- 1 until 4)
      println(i)

    for (file <- filesHere if file.getName.endsWith("t"))
      println(file)

    for (file <- filesHere
         if file.isDirectory;
         if file.getName.endsWith("t"))
      println(file)


    // 嵌套
    def grep(pattern: String) = for (
      file <- filesHere
      if file.getName.endsWith("t"); // 超过一个过滤器,if 子句需要用 分号分隔
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ":" + line.trim)


  }

  def greet() {
    println("hi")
  }

  def fileLines(file: File) =
    Source.fromFile(file).getLines().toList


}
