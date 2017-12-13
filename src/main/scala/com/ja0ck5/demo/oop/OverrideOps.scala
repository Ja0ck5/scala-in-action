package com.ja0ck5.demo.oop

/**
  * Created by Jack on 2017/10/27.
  */
class OverrideOps {

}


class Person1(val nam: String, var age: Int) {
  println("constructor of Person1")
  val school = "BJU"

  def sleep = "8 hours"

  override def toString: String = "I am a Person1 through overriding"
}


class Worker(name: String, age: Int, val salary: Long) extends Person1(name, age) {

  println("This is the subClass of Person,Primary Constructor of Worker!")
  override val school: String = "Spark"

  override def toString: String = "I am a Worker!" + super.sleep

}

object OverrideOps {
  def main(args: Array[String]): Unit = {
    val w = new Worker("Spark",5,1000000)
    println("School:" + w.school)
    println("Salary : " + w.salary)
    println(w)
  }
}