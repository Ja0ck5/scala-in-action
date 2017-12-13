package com.ja0ck5.demo.hello

object ForFunctionOps {

  def main(args: Array[String]): Unit = {

    // for
    for (i <- 1 to 2; j <- 1 to 2) println(100 * i + j)
    println("ln for")
    for (i <- 1 to 2; j <- 1 to 2 if i != j) println(100 * i + j)

    // function
    def add(x: Int) = x + 100

    println("the result of add function is : " + add(100))
    val addAno = (x: Int) => x + 100
    println("the result of addAno is : " + addAno(100))

    //
    def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

    println("the result of fac is : " + fac(10))


    // default param value
    def combineContent(content: String, left: String = "[", right: String = "]") = left + content + right

    println(combineContent("Today is a good day"))

    // 可变参数
    def connected(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
    }
    println(connected(10,20,30,40,11))
  }
}
