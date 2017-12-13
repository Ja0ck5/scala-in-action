package com.ja0ck5.demo.advanced

import java.io.File

import scala.io.Source

/**
  * Created by Jack on 2017/12/6.
  */

class RichFile(val file : File){
  def read = Source.fromFile(file.getPath).mkString
}

object FileContext{
  implicit def file2RichFile(file:File) = new RichFile(file)
}

object ImplicitConversionsOps {

  def main(args: Array[String]): Unit = {
    import FileContext.file2RichFile
    println(new File("D:/f.txt").read)
  }

}
