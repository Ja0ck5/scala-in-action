package com.ja0ck5.demo.oop

class P[+T](val f: T, val s: T) {
  // 逆变的参数出现在协变的类型T
  //  def repalceF(newF : T) = new P[T](newF,s);
  // 解决办法
  def repalceF[R >: T](newF: R) = new P[R](newF, s);

}

object VariantPosition {

}
