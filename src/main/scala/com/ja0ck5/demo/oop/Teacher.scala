package com.ja0ck5.demo.oop

//class Teacher {
//
//  var name: String = _ // public getter setter
//
//  private var age = 27 // private getter setter
//
//  private[this] val gender = 1 // 1=male;0 = female
//
//  def this(name: String) {
//    this
//    this.name = name
//  }
//
//  def sayHello: Unit = {
//    println(this.name + ":" + this.age + ":" + this.gender)
//  }
//
//}
// private constructor cannot use
class Teacher /*private*/ (val name: String, val age: Int) {
  println("this is the primary constructor")
  var gender: String = _
  println("gender:" + gender)

  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }

}


object OopInScalaTeacher {
  def main(args: Array[String]): Unit = {
    // common
    //    val teacher = new Teacher
    //    teacher.name = "Scala"
    //    teacher.sayHello

    val teacher  =  new Teacher("Scala",5)
    println("age : " + teacher.age)
    val teacher1  =  new Teacher("Scala",5,"male")


  }
}
