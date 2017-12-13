package com.ja0ck5.demo.advanced

class ImplicitParams {


}

object ContextImplicit {
  implicit val default: String = "Java"
}

object Params {
  def print(content: String)(implicit language: String): Unit = {
    println(content + ":" + language)
  }
}

object ImplicitParams{
  def main(args: Array[String]): Unit = {
    Params.print("Spark")("Scala")
    import ContextImplicit._
//    import ContextImplicit.default

    Params.print("Hadoop")
  }
}

