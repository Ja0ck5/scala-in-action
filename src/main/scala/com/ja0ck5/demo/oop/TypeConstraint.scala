package com.ja0ck5.demo.oop

object TypeConstraint {

  def main(args: Array[String]): Unit = {
    // A =:= B 表示 类型 A 等同于 类型B
    // A <:< B 表示 类型 A 为 类型B 的子类型
    def rocky[T](i: T)(implicit env: T <:< java.io.Serializable): Unit = {
      println("Life is short,u need spark")
    }

    rocky("spark")
    //    rocky(100) //Error:(12, 10) Cannot prove that Int <:< java.io.Serializable.
  }
}
