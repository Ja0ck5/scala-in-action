package com.ja0ck5.programming.oop

/**
  * Created by Jack on 2018/2/1.
  */
object FindLongLines {

  def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }

}
