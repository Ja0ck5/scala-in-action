package com.ja0ck5.programming.oop.combine

/**
  * 如果省略了 extends 子句,Scala 编译器将隐式地假设你的类扩展自 scala.AnyRef. 这与 Java 的 java.lang.Object 相同
  * 因此 Element 类隐式得扩展了 AnyRef 类
  *
  * 继承(inheritance) 表示超类的所有成员也是子类的成员，但以下两种情况例外:
  * 1. 超类的私有成员不会被子类继承
  * 2. 超类中的成员若与子类中实现的成员具有相同名称和参数则不会被子类继承。这种情况被称为子类的成员重写了超类的成员。如果子类的成员是具体的而超类中的是抽象的,
  * 我们也可以说具体的成员实现(implements) 了抽象成员
  *
  * 统一访问原则只是 Scala 在对待字段和方法上比 Java 更统一的一个方面。
  * 另一个差异是 Scala 里的字段和方法属于相同的命名空间。折让字段可以重写无参数方法。例如:
  * 可以改变 ArrayElement 类中 contents 的实现将其从一个方法变为一个字段，而无需修改类 Element 中 contents 的抽象方法定义
  *
  * 另一方面 Scala 里禁止在同一个类里面用同样的名称定义字段和方法
  * 一般来说 Scala 仅有两个命名空间: 值(字段,方法,包,单例对象) / 类型
  * Scala 把字段和方法放进同一个命名空间的理由很明确,因为这样就可以实现使用 val 重写无参数方法
  *
  * Scala 包与字段和方法共享相同的命名空间是为了能够引入包，而不仅仅是引入类型名以及单例对象的字段和方法。这样是无法在 Java 中做到的。
  *
  *
  *
  * Created by Jack on 2018/3/5.
  */
class ArrayElement(conts: Array[String]) extends Element {
  //  override def contents: Array[String] = conts
  val contents: Array[String] = conts

  def above(that: Element): Element = {
    new ArrayElement(this.contents ++ that.contents) // ++ 连接两个数组
  }
  // 指令式
  //  def beside(that: Element): Element = {
  //    val contents = new Array[String](this.contents.length)
  //    for (i <- 0 until this.contents.length)
  //      contents(i) = this.contents(i) + that.contents(i)
  //    new ArrayElement(contents)
  //  }
  
  def beside(that: Element): Element = {
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }
}

class Cat {
  val dangerous = false
}

class Tiger(override val dangerous: Boolean,
            private var age: Int) extends Cat {

}


class Tiger2(param1: Boolean,
             param2: Int) extends Cat {
  override val dangerous = param1
  private var age = param2
}

/**
  * 1. 若所有重写了父类具体成员的子类成员必须带有 override
  * 2. 若成员实现的是同名的抽象成员时,则 override 是可选的
  * 3. 若成员并未重写或实现其他基类里的成员则禁用 override 修饰符
  *
  * @param s
  */
class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length

  override def height: Int = 1
}

// 变量和表达式上的方法调用是 动态绑定(dynamically bound)的. 这意味着被调用的实际方法实现取决于运行期对象基于的类，而不是变量或表达式的类型



