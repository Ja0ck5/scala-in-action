package com.ja0ck5.programming.oop

import ChecksumAccumulator.calculate

/**
  * 在单例对象后面 extends App .
  * 然后花括号之间的代码都可以类似于在 main 方法中执行
  *
  * 因为 trait App 声明了带有合适签名的 main 方法,并被单例对象继承
  * 花括号之间的代码被收集到 单例对象 的主构造器(primary constructor),并在类被初始化时执行。
  *
  * 继承自App 比编写完整的 main 方法更方便，不过有如下缺点:
  * 1. 如果想访问命令行参数的话，不能用它，因为 args 数组不可访问。使用命令行参数，必须编写完整的 main 方法
  * 2. 某些 JVM 线程模型里的局限,对于多线程的程序，需要自行编写 main 方法
  * 3. 某些 JVM 的实现没有优化被 trait App 执行的对象的初始化代码
  *
  * 因此，只有 程序相对简单 并且 单线程 的情况下才可以继承 App
  *
  * Created by Jack on 2018/1/11.
  */
object FallWinterSpringSummer extends App{

  for (season <- List("fall","winter","spring","summer")){
    println(season+":"+ calculate(season))
  }






}
