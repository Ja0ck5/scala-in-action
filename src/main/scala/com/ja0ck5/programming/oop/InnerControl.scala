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
    val file = new FileReader("input.txt")
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>
        println("FNF")
      case ex: IOException =>
        println("IOE")
    } finally {
      // 此处惯例与 Java 一样，Scala 还可以使用另一种称为 出借模式(loan pattern) 的技巧更简洁地表达到同样的目的
      file.close
    }


  }

  def greet() {
    println("hi")
  }

  def fileLines(file: File) =
    Source.fromFile(file).getLines().toList


}
