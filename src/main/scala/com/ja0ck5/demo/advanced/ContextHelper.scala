package com.ja0ck5.demo.advanced

import java.io.File

import scala.io.Source

/**
  * Created by Jack on 2017/12/11.
  */
object ContextHelper {

  implicit class FileEnhancer(file: File) {
    def read = Source.fromFile(file.getPath).mkString
  }

  implicit class Op(x: Int) {
    def add(second: Int) = x + second
  }

}

object ImplicitsClass{
  def main(args: Array[String]): Unit = {
    import ContextHelper._
    println(1.add(2))
    println(new File("D:/f.txt").read)
  }
}
