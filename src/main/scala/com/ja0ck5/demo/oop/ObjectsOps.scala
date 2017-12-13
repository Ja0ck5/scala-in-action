package com.ja0ck5.demo.oop

object ObjectsOps {

  def main(args: Array[String]): Unit = {
    println(University.newStudentNo)
    println(University.newStudentNo)

    //    University.studentNo // inaccessible

    val array = Array(1, 2, 3, 4, 5) // object Array 是 class Array 的伴生对象


  }

}

class University {
  val id = University.newStudentNo
  private var number = 0

  University.studentNo // can be accessible

  def aClass(number: Int) = this.number = number
}

/**
  * class University 的伴生对象
  */
object University {
  private var studentNo = 0

  def newStudentNo = {
    studentNo += 1
    studentNo
  }
}