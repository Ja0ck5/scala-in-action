package com.ja0ck5.demo.oop

/**
  * Created by Jack on 2017/10/31.
  */
object RegExpressOps {

  def main(args: Array[String]): Unit = {
    val regex = """([0-9]+) ([a-z]+)""".r

    val numPattern = "[0-9]+".r
    val numberPattern = """\s+[0-9]+\s""".r

    // findAllIn 方法返回遍历所有匹配项的迭代器
    for(matchString <- numPattern.findAllIn("999345 Scala, 22298 Spark")) println(matchString)

    // 找到首个匹配项
    println(numPattern.findFirstIn("99ss java, 222 hadoop"))

    val numitemPattern = """([0-9]+) ([a-z]+)""".r

    val numitemPattern(num,item) = "99 hadoop"

    val line = "93459 spark"

    line match{// 模式匹配
      case numitemPattern(num,blog) => println(num+"\t" + blog)
      case _ => println("oh...")
    }

  }

}
