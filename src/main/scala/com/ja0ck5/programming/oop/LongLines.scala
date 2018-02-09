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
  * 为什么要使用 尾下划线
  * Scala 的部分应用函数语法凸显了 Scala 与经典函数式语言 Haskell 或 ML 之间设计 折中 的差异。
  * 在经典的函数式语言中，部分应用函数被当做普通的例子。
  * 这些语言有着非常严格的静态类型系统能够暴露出你在部分应用中可能犯的所有错误。
  * Scala 与 指令式语言如 Java 关系近得多，在这些语言中没有应用所有参数的方法会被认为是错误的
  * 子类型推断的面向对象的传统 和 全局的跟类型能接受一些被 经典函数式语言认为是错误的程序
  * 例如：
  *
  * 假如 误以为 List 的 drop(n:Int) 方法是 tail(), 导致不知道传递给 drop 需要一个数值。
  * 也许会写成 println(drop) 。
  * 如果 Scala 采用部分应用函数在哪儿都 OK 的经典函数式传统，这个代码就将通过类型检查。
  * 然而 打印出 <function> 。可能发生的事情就是 表达式 drop 被看做函数对象。
  * 因为 println 可以传入任何类型的对象。
  * 为了避免这样的情况，Scala 需要你指定显示省略的函数参数，尽管标识简单到用一个下滑线 '_'
  * 也只有再需要函数类型的地方，Scala 才允许你省略这个下划线 _
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
    val nos = List(-11, -10, -5, 0, 5, 10)
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
    println(f(5, 10))

    // 部分应用函数
    // 以这种方式使用下划线时，就是正在写一个部分应用函数(partially applied function).
    nos.foreach(println _)

    // 在Scala 中，调用函数时，传入任何需要的参数，实际是把函数应用到参数上
    def sum(a: Int, b: Int, c: Int) = a + b + c

    println(sum(1, 2, 3))
    // 部分应用函数是一种表达式，并不需要提供函数需要的所有参数。代之以 仅提供的部分或不提供所需参数。
    // 名为 a 的变量指向一个函数值对象。这个函数值是由 scala 编译器驿站部分应用函数表达式 sum _ ，自动产生的类的一个实例
    // 编译器产生的类有一个 apply 方法(产生的类扩展了特质 Function3,定义了3个参数的 apply 方法)
    val a = sum _
    println(a(1, 2, 3))
    // 之所以带 3 个参数是因为 sum _ 表达式缺少的参数数量为 3. Scala 编译器把表达式 a(1,2,3) 翻译成对函数值的 apply 方法调用
    // Scala 编译器根据表达式 sum _ 自动产生的类里的 apply 方法，简单地把这 3 个缺失的参数传递到 sum 并返回结果。
    val aApply = a.apply(1, 2, 3)
    println(aApply)

    // 为 sum 提供了第一个和最后一个参数，但是缺少 第二个参数。因为仅有一个参数缺少，Scala编译器产生的新的函数类，其apply方法带一个参数。
    val b = sum(1, _: Int, 3)
    println(b(2))

    // 如果正在写一个省略所有参数的偏程序表达式，而且在代码的那个地方正需要一个函数，可以去掉下划线
    nos.foreach(println)

    // 闭包
    // 以上所有函数字面量的例子仅参考了传入的参数。例如，(x:Int) => x > 0,函数体 x>0 用到的唯一变量x,被定义为函数参数。
    // 然而也可以参考定义在其他地方的变量 (x:Int) => x + more // what more?
    // 从这个函数看 more 是个自由变量: free variable, 因为函数自字面量自身没有给出其含义。而 x 变量是一个绑定变量: bound variable
    // 因为它在函数的上下文中有明确意义: 被定义为函数的唯一参数是 Int. 如果你尝试独立使用这个函数字面量，范围内没有任何 more 的定义编译器会报错

    // 只要有一个叫做 more 的 某种东西，同样的函数字面量将工作正常:

    var more = 1
    val addMore = (x: Int) => x /*绑定变量*/ + more /* 自由变量 */
    // 依照这个函数字面量在运行时创建的函数值(对象)被称为 闭包: closure. 名称源自于通过"捕获"自由变量的绑定，从而对函数字面量执行的"关闭"行动
    // 不带自由变量的函数字面量,如 (x:Int) => x+1 被称为 封闭项(closed term).这里 项(term) 指的是一小部分源代码。因此依照这个函数字面量在运行时创建的函数值
    // 严格意义上来讲就不是闭包。 因为 (x:Int) => x+1 在编写的时候就已经封闭了。 但任何带有自由变量的函数字面量，如 (x: Int) => x + more，都是开放项(open term)
    // 因此，任何以 (x: Int) => x + more 为模板在运行期创建的函数值将必须捕获对自由变量 more 的绑定。因此得到的函数值将包含指向捕获的 more 变量的索引。
    // 又由于 函数值 是关闭这个 开放项 (x: Int) => x + more 的行动的最终产物，因此被称为闭包。

    // 直觉上 Scala 的闭包捕获了变量本身，而不是变量指向的值。（相对地，Java 内部类根本不允许访问外围范围内可以改变的变量，因此 Java 到底是捕获了变量还是捕获了它当前具有的值就没有差别了）
    println(addMore(1000))
    more = 9999
    println(addMore(1000))
    // 依照 (x: Int) => x + more 创建的闭包看到了闭包之外做出的对 more 的变化。反过来也同样。闭包对捕获变量做出的改变在闭包之外也可见

    var sumInFor = 0
    nos.foreach(sumInFor += _)
    // 尽管这是一个在运行期改变 sumInFor 的闭包，其结果在闭包外也是可见的
    println(sumInFor) // -11

    // 如果 闭包访问了某些在程序运行时有若干不同备份的变量，例如 闭包使用了某个函数的本地变量，并且函数被调用很多次会怎样？ 每次访问使用的变量是哪个实例？
    // 通常情况下: 使用的实例是在那个闭包被创建的时候活跃的。

    // 每次被调用时都会创建一个新闭包。每个闭包都会访问闭包创建时活跃的 more 变量
    def makeIncreaser(more: Int) = (x: Int) => x + more

    val inc1 = makeIncreaser(1)
    // 这里捕获值 1 当做 more 的绑定的闭包被创建并返回
    val inc9999 = makeIncreaser(9999) // 捕获值 9999 当做 more 的绑定的闭包被创建并返回
    // 返回的结果依赖于闭包被创建时 more 是如何定义的
    println(inc1(10))
    more = -1000 // 与此时定义的 more 没有关系
    // 在这样的情况下，Scala 编译器重新做了布局以使得捕获的参数继续存于堆中，而不是堆栈中，因此可以保留在创建它的方法调用之外。
    // 这种重新布局的工作是自动完成的，只需关注想要的变量: val var 或参数即可
    println(inc9999(9999))

    // 重复参数(可变参数)
    def echo(args: String*) = for (arg <- args) println(arg)

    echo("haha", "gary")

    val arr = Array("What's", "up", "bro?")

    echo(arr: _*)

    // 尾递归
    // 将 var 的 while 换成仅使用 val 这种更函数式的风格,可以使用递归
    //    def approximate(guess: Double): Double =
    //    if (isGoodEnough(guess)) guess
    //    else approximate(improve(guess))
    // 尾递归函数追踪
    // 这个函数不是尾递归,因为在递归调用之后执行了递增操作。
//    def boom(x: Int): Int =
//    if (x == 0) throw new Exception("boom!")
//    else boom(x - 1) + 1

//    boom(3)

    // 修改成尾递归
    def bang(x: Int): Int =
      if (x == 0) throw new Exception("bang!")
      else bang(x - 1)

    bang(5)

  }

}
