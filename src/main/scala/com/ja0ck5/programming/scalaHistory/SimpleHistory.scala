package com.ja0ck5.programming.scalaHistory

/**
  * Created by Jack on 2017/12/13.
  */
class SimpleOperations {

}

object SimpleOperations {
  def main(args: Array[String]): Unit = {
    val s = "HaHa Scala"
    //    s.foreach(s1 => println(s1))
    //    s.foreach(println)

    //    for(s1 <- s){
    //      val r = 1 + 2
    //      println(s1)
    //    }

    // list 本身是不可变的,这里不写成 new List 因为 List.apply() 是定义在 scala.List 伴生对象中的工厂方法
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    // 这里实际上使用新的值重建了列表再返回
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwoThreeFour)

    // 列表常用的操作符 '::' ，读作 'cons'. 可以把新元素组合刀现有列表的最前端，然后返回新列表、

    val twoThree = List(2, 3)
    val oneTwoThree = 1 :: twoThree
    println(oneTwoThree)

    // 因为 Nil 是空列表的简写，所以可以使用 cons 操作符包所有元素穿起来，并以 Nil 作结尾来定义新列表
    val nilEndOneTwoThree = 1 :: 2 :: 3 :: Nil
    println(nilEndOneTwoThree)

    //元组，容器对象，和List 一样，元组也是不可变的。但和 list 不同，元组可以包含不同类型的元素
    val pair = (99, "Luft ballons", 'a', "ha")
    // 为什么不能用访问 List 的方法来访问元组，如 pair(0). 因为 List 的 apply 方法始终返回同样的类型
    println(pair._1, pair._2)

    // set
    var jetSet = Set("Boeing", "Airbus")
    // 可变和不可变 都提供了 + 方法，可变 set 是把元素加入自身，而不可变 set 将产生一个全新的 set
    jetSet += "Lear"
    println(jetSet)

    // 可变 set
    import scala.collection.mutable.Set
    val movieSet = Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)

    // map
    import scala.collection.mutable.Map

    val treasureMap = Map[Int,String]()
    treasureMap += (1 -> "Go to ice island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))

    val res = Array("zero","one","two").mkString("\n")
    assert(res == "zero\none\ntwo")
  }
}
