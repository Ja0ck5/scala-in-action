package com.ja0ck5.demo.oop

abstract class Item

case class Book(description: String, price: Double) extends Item

case class Bundle(description: String, price: Double, items: Item*) extends Item


object PatternMatchCaseClassObjectNested {
  def main(args: Array[String]): Unit = {
    def caseClassNested(item: Item) = item match {
      case Bundle(_, _, art@Book(_, _), rest@_*) => println(art.description + ":" + art.price)
//      case Bundle(_, _, art@Book(desc, _), rest@_*) => println("The first description : " + desc)
      case _ => println("Something else...")
    }

    caseClassNested(Bundle("11111 Special's", 30.0, Book("Scala for the Spark developer", 66.6), Bundle("Hadoop", 40.0, Book("Hive", 79.5), Book("Hive", 79.5), Book("HBase", 89.5))))
    caseClassNested(Bundle("12121 HAHA's", 35.5, Book("Spark for the Impatient", 35.5)))
  }
}
