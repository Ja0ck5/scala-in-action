package com.ja0ck5.demo.oop

class MultiType {

}

object MultiType {
  def main(args: Array[String]): Unit = {
    def arrayMake[T: Manifest](first: T, second: T) = {
      val r = new Array[T](2)
      r(0) = first
      r(1) = second
      r
    }

    arrayMake(1, 2).foreach(println)

    def manif[T](x: List[T])(implicit m: Manifest[T]) = {
      if (m <:< manifest[String])
        println("List strings")
      else
        println("Some other type")
    }

    manif(List("Spark", "Hadoop"))
    manif(List(1, 2))
    manif(List("Spark", 4))

    val m = manifest[Array[String]]
    println(m)
    val cm = classManifest[Array[String]]
    println(cm)
  }
}
