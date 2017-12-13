package com.ja0ck5.demo.oop

object MergeSort {

  def main(args: Array[String]): Unit = {
    def mergeSort[T](less: (T, T) => Boolean)(input: List[T]): List[T] = {

      def merge(xList: List[T], yList: List[T]): List[T] =
        (xList, yList) match {
          case (Nil, _) => yList
          case (_, Nil) => xList
          case (x :: xtail, y :: ytail) => if (less(x, y)) x :: merge(xtail, yList)
          else y :: merge(xList, ytail)
        }

      val n = input.length / 2
      if (0 == n) input
      else {
        val (x, y) = input splitAt n
        merge(mergeSort(less)(x), mergeSort(less)(y))
      }
    }

    println(mergeSort((x: Int, y: Int) => x < y)(List(3, 7, 5, 9, 6)))
    val reverseList = mergeSort((x: Int, y: Int) => x > y) _
    println(reverseList(List(3, 7, 5, 9, 6)))
  }

}
