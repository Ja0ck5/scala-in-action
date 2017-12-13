package com.ja0ck5.demo.oop

class Person {
  private var age = 0

  //  def increment() {
  //    age += 1
  //  }

  def increment = age += 1

  def current = age
}

class Student {
  //  var age = 0 // 默认就是 private 级别，并且生成 getter setter
  private var priAge = 0

  def age = priAge

  private[this] var priGender = 0// 只归当前对象所有了

  def gender = priGender

  val name = "Scala" // 只有 getter 没有 setter

  def isYouger(other: Student) = priAge < other.priAge
//  def isMan(other: Student) = priGender < other.priGender // inaccessible

}

object HelloOop {

  def main(args: Array[String]): Unit = {
    val person = new Person
    person.increment
    println(person.current)

    val student = new Student
    student.age
//    val student.age = 10 // 实际上 是  student.age_ setter
    println(student.age)
    println(student.age)
  }

}
