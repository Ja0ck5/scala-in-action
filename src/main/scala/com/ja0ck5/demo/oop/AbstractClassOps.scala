package com.ja0ck5.demo.oop

/**
  * Created by Jack on 2017/10/27.
  */
class AbstractClassOps {
  var id: Int = _
}


abstract class SuperTeacher(val name: String) {
  var id: Int
  var age: Int

  def teach
}

class Teacher4Maths(name: String) extends SuperTeacher(name) {
  override var id: Int = name.hashCode
  override var age: Int = 29

  //  override def teach: Unit = ???
  override def teach {
    println("Maths Teaching!!!")
  }
}

object AbstractClassOps {
  def main(args: Array[String]): Unit = {
    val teacher = new Teacher4Maths("Spark")
    teacher.teach

    println("id:"+teacher.id + ",name:" + teacher.name + ",age:" + teacher.age)
  }
}
