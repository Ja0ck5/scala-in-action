package com.ja0ck5.demo.oop

class PersonVo

class StudentVo extends PersonVo

/**
  * 协变
  *
  * @param args
  * @tparam T
  */
class CVo[+T](val args: T)

class Svo[+T](arg: T) extends CVo[T](arg)

/**
  * 逆变
  *
  * @tparam T
  */
trait FriendVo[-T] {
  def makeFriend(sb: T)
}

object VarianceOps {
  def makeFriendWithU(s: StudentVo, f: FriendVo[StudentVo]) {
    f.makeFriend(s)
  }

  def main(args: Array[String]): Unit = {
    val value: CVo[PersonVo] = new CVo[StudentVo](new StudentVo)
    print(value)
  }
}
