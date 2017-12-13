package com.ja0ck5.demo.oop

import scala.io.Source

class FunctionOps {
}

object FunctionOps {
  def processFile(filename: String, width: Int): Unit = {
    def processLine(line: String): Unit = {
      if (line.length > width) {
        println(filename + ":" + width)
      }
    }

    val source = Source.fromFile(filename);
    for (line <- source.getLines)
      processLine(line)

  }


  def main(args: Array[String]): Unit = {
//    val width = args(0).toInt
//    for (arg <- args.drop(1))
//      processFile(arg, width)

    var increase = (x: Int) => x + 1
    increase(10)

    increase = (x: Int) => x + 9999

    val someNumbers = List(-11, -10, -5, 0, 5, 10)

    someNumbers.foreach((x: Int) => println(x))

    someNumbers.filter((x: Int) => x > 0)
    someNumbers.filter((x) => x > 0)
    someNumbers.filter(x => x > 0)
    someNumbers.filter(_ > 0)

    val f = (_: Int) + (_: Int)
    println(f(5, 10))


  }
}

