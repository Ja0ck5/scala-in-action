package com.ja0ck5.demo.oop

import scala.collection.immutable.{Queue, Stack}
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object ListBufferArrayQueueStackOps {

  def main(args: Array[String]): Unit = {
    val listBuffer = new ListBuffer[Int]
    listBuffer += 1
    listBuffer += 2
    println(listBuffer)

    val arrayBuffer = new ArrayBuffer[Int]
    arrayBuffer += 1
    arrayBuffer += 2
    println(arrayBuffer)

    val empty = Queue[Int]()
    val q1 = empty.enqueue(1)
    println(q1)
    val q2 = q1.enqueue(List(2, 3, 4, 5))
    println(q2)

    val (element, left) = q2.dequeue
    println(element + ":" + left)

    val q = mutable.Queue[String]()
    q += "a"
    println(q)
    q ++= List("b", "c")
    println(q)
    println(q.dequeue)
    println(q)

    val s = new mutable.Stack[Int]
    s.push(1)
    s.push(2)
    s.push(3)
    println(s)
    println(s.top)
    println(s)
    println(s.pop)
    println(s)
//    val stack = new Stack[Int]



  }

}
