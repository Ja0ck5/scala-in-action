package com.ja0ck5.demo.advanced

/**
  * Created by Jack on 2017/11/30.
  */
trait CompositeType1;

trait CompositeType2;

class CompositeType extends CompositeType1 with CompositeType2 {
}

object CompositeType {
  def compoundType(x: CompositeType1 with CompositeType2) = {
    println("Composite Type in global method")
  }

  def main(args: Array[String]): Unit = {

    compoundType(new CompositeType1 with CompositeType2)
    //    compoundType(new CompositeType1/* with CompositeType2*/)

    object innerCompositeType extends CompositeType1 with CompositeType2

    compoundType(innerCompositeType)

    // alias
    type compositeTypeAlias = CompositeType1 with CompositeType2

    def compositeTypeLocal(x: compositeTypeAlias) = println("Composite Type in local method")

    val compositeTypeClass = new CompositeType
    compositeTypeLocal(compositeTypeClass)
    // 即是 CompositeType1 又是 CompositeType2 还必须实现 init() 方法
    type alias = CompositeType1 with CompositeType2 {def init(): Unit}

  }
}
