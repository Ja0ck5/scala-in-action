package com.ja0ck5.programming.oop

import java.io.{File, FileNotFoundException, FileReader, IOException}

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
      // 代码中重复出现 line.trim 这是个不可忽略的计算,因此你或许希望只算一遍,这可以通过等号绑定到新变量实现.
      // 绑定的变量被当做 val 引入和使用，不过不带关键字 val
      if line.trim.matches(pattern)
    ) println(file + ":" + line.trim)

    def grep2(pattern: String) = for (
      file <- filesHere
      if file.getName.endsWith("t"); // 超过一个过滤器,if 子句需要用 分号分隔
      line <- fileLines(file);
      // 代码中重复出现 line.trim 这是个不可忽略的计算,因此你或许希望只算一遍,这可以通过等号绑定到新变量实现.
      // 绑定的变量被当做 val 引入和使用，不过不带关键字 val
      trimmed = line.trim
      if trimmed.matches(pattern)
    ) println(file + ":" + trimmed)

    // 制造新集合 到现在为止所有的例子都是枚举完就释放,除此之外，你还可以创建一个值去记住每一次的迭代
    // 只要再 for 表达式后面增加  yield 关键字

    def tFiles =
      for {file <- filesHere
           if file.getName.endsWith("t")
      } yield file

    println(tFiles.length)

    val forLineLengths =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(".*for.*")
      } yield trimmed.length

    println(forLineLengths.length)

    // 使用 try 处理异常
    // 抛出异常的类型是 Nothing 。尽管 throw 不实际产生任何值,你还是可以把它当作表达式。if 的一个分支计算值，另一个抛出异常并得出 Nothing
    // 整个 if 表达式的类型就是那个实际计算值的分支的类型
    val n = 2
    val half =
      if (n % 2 == 0)
        n / 2
      else throw new RuntimeException("n must be even")

    // 如果都不是以下类型异常，那么 try-catch 将终结并把异常上升出去
    // 与 Java 的差别存在于 Scala 里不需要捕获检查异常(checked exception),或把它们声明再 throws 子句中。如果愿意,还可以用
    // @throws 注解声明 throws 子句，但不是必须
    // try-catch-finally 也产生值。
    // 如果异常被抛出但没被捕获，表达式就没有返回值。由 finally 子句计算得到的值，即使有也会被抛弃，它不应该修改主函数体 或 catch 子句中计算的值
//    val file = new FileReader("input.txt")
//    try {
//      val f = new FileReader("input.txt")
//    } catch {
//      case ex: FileNotFoundException =>
//        println("FNF")
//      case ex: IOException =>
//        println("IOE")
//    } finally {
//      // 此处惯例与 Java 一样，Scala 还可以使用另一种称为 出借模式(loan pattern) 的技巧更简洁地表达到同样的目的
//      file.close
//    }

    // 通常避免用 finally 子句返回值
    def f(): Int = try {
      return 1
    } finally {
      return 2
    } // 2

    def g(): Int = try {
      1
    } finally {
      2
    } // 1

    // 匹配表达式  match
    // Scala 中的 match 类似于其他语言的 switch ，它可以提供多个备选项(alternative)中做选择。
    // 基本上 match 表达式可以让你使用任意的模式(pattern)做选择。
    // 与 Java 的 switch 语句比，任何类型的常量都可以做比较样本(case)
    // 另一个区别是 case 的最后没有 break 取而代之的是 break 是隐含的。
    // match 也能产生值
    val firstArg = if (args.length > 0) args(0) else ""

    val friend =
      firstArg match {
        case "salt" => println("pepper")
        case "chips" => println("salsa")
        case "eggs" => println("bacon")
        case _ => println("huh?")
      }
    println(friend)

    // 不再使用 break 和 continue
    // scala 去掉这些命令是因为它们与函数式字面量融合的不太好。充分利用函数字面量代替
    var i = 0
    var foundIt = false
    while (i < args.length && !foundIt) {
      if (!args(i).startsWith("-")) {
        if (args(i).endsWith("-"))
          foundIt = true
      }
    }

    // 不用 var 做循环的递归替代方法
    // Scala 编译器不会对一下代码生成递归函数。因为所有的递归调用都在尾调用(tail-call) 位置，编译器会产生出与 while 循环类似的代码
    // 每个递归调用将被实现为回到函数开始位置的跳转
    def searchFrom(i: Int): Int =
    if (i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)

    var searchFromI = searchFrom(0)

    // Java 不允许在内部范围内创建与外部范围变量同名的变量。在 Scala 中，内部变量被认为遮蔽(shadow)了同名的外部变量，因为在内部范围中外部变量变得不可见
    val a = 1; // 在花括号之前需要加分号
    {
      val a = 2
      println(a)
    }
    println(a)


    // 指令式风格 打印乘法表
    def printMultiTable(): Unit = {
      var i = 1
      while (i <= 10) {
        var j = 1
        while (j <= 10) {
          val prod = (i * j).toString
          var k = prod.length
          while (k < 4) {
            print("  ")
            k += 1
          }
          print(prod)
          j += 1
        }
        println()
        i += 1
      }
    }

    // 函数式风格 重构指令式风格，将 标准输出上打印的乘法表 重构成 作为字符串返回
    // 以序列的形式返回一行乘法表
    def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

    // 以字符串形式返回一行乘法表
    def makeRow(row: Int) = makeRowSeq(row).mkString

    // 以字符串形式返回乘法表，每行记录占一行字符串
    // printMultiTable 函数的另一个暗示其指令式风格的信号在于 它的 while 循环和 var. 与之相对
    // multiTable 函数使用了 val 类型变量、for 表达式以及帮助函数(helper function).并调用了 mkString 方法
    // 提炼两个帮助函数 makeRow 和 makeRowSeq ，使代码容易阅读。函数 makeRowSeq 使用了 可以从 1 to 10 枚举列数的 for 表达式
    // 其函数体计算行和列的城际，决定乘积前占位的空格，并生成由占位空格。乘积合并成的字符串。 for 表达式返回以这些生成字符串作为元素的序列。
    // 而另一个函数 makeRow 只是对 makeRowSeq 返回的结果调用 mkString 函数，把序列中的字符串合并成一个字符串返回
    def multiTable() = {
      val tableSeq = // 行记录字符串的序列
        for (row <- 1 to 10)
          yield makeRow(row)

      tableSeq.mkString("\n")
    }


  }

  def greet() {
    println("hi")
  }

  def fileLines(file: File) =
    Source.fromFile(file).getLines().toList


}
