package com.ja0ck5.demo.oop

abstract class PersonOp

case class StudentOp(age: Int) extends PersonOp

case class WorkerOp(age: Int, salary: Double) extends PersonOp

case object Shared extends PersonOp


object CaseClassObjectOps {

  def main(args: Array[String]): Unit = {

    def caseOps(person: PersonOp) = person match {
      case StudentOp(age) => println("I'm a student who is " + age + " years old")
      case WorkerOp(_, salary) => println("I'm a worker who is _ years old and salary is " + salary)
      case Shared => println("No properties")
    }

    val s = StudentOp(18)
    caseOps(s)
    caseOps(Shared)

    val w1 = WorkerOp(29,20000.99)
    caseOps(w1)
    val w2 = w1.copy(salary = 30000.99)
    caseOps(w2)
    val w3 = w1.copy(age = 19)
    caseOps(w3)
  }
}
