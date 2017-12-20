package com.ja0ck5.programming.oop

/**
  * Created by Jack on 2017/12/18.
  */
class ChecksumAccumulator {
  // public 是 Scala 的 默认访问级别
  private var sum = 0;

  /**
    * Scala 里的方法参数的一个重要特征是 都是 val , 不是 var
    * val 更易于理清头绪。不需要分析更多的代码，已确定是否 val 被重新赋值
    *
    * @param b
    */
  def add(b: Byte): Unit = {
    //    b += 1 编译错误
    sum += b
  }

  def checkSum(): Int = {
    return ~(sum & 0xFF) + 1
  }

  /**
    * 如果去掉 方法体 前面的 等号，那么方法的结果类型就必定是 Unit
    * Scala 编译器可以把任何类型转换为 unit
    * 如果方法的最后结果为 String
    * 但是 结果类型被声明为 unit
    * 那么 String 将被转为 Unit 并丢弃原值
    *
    * @param b
    */
  def add2(b: Byte) {
    sum += b
  }

  def checkSum2(): Int = ~(sum & 0xFF) + 1

}
