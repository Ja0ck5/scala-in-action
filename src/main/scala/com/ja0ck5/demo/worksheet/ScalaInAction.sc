import scala.collection.mutable.ArrayBuffer

object ScalaInAction {
  println("Welcome to the Scala worksheet")
  val s = Array("Hello", "world")
  s(0) = "GoodBye"
  s
  for (elem <- s) {
    println(elem)
  }

  val b = ArrayBuffer[Int]()
  b += 1
  b += (1, 2, 3, 5)
  b ++= Array(11, 13, 12, 15)
  b.trimEnd(5)
  b
  b.insert(2, 6)
  b
  b.insert(2, 7, 8, 9)
  b
  b.remove(2)
  b
  b.remove(2, 3)
  b
  b.toArray


  val a = new Array[String](10)
  for (i <- 0 until a.length) println(a(i))

  val c = Array(2, 3, 5, 7, 11)
  val result = for (elem <- c) yield 2 * elem
  val noYieldResult = for (elem <- c) 2 * elem
  c.filter(_ % 2 == 0).map(2 * _)

  c.filter(elem => elem % 2 == 0).map(2 * _)

  Array(1, 7, 2, 9).sum

  ArrayBuffer("Marry", "Json", "a", "Little", "Lamb").max


  val d = ArrayBuffer(1, 7, 2, 9)
  val dSorted = d.sorted

  val e = Array(1, 7, 2, 9)
  scala.util.Sorting.quickSort(e)
  e

  e.mkString(" and ")

  a.mkString("<", ",", ">")

  val matrix = Array.ofDim[Double](3, 4)
  matrix(2)(1) = 42

  val triangle = new Array[Array[Int]](10)
  for (i <- 0 until triangle.length) {
    triangle(i) = new Array[Int](i + 1)
    triangle(i).length
  }


  val ages = Map("John" -> 27, "Silver" -> 5)
  for ((k, v) <- ages) {
    println("k:" + k + ",v:" + v)
  }

  for ((k, _) <- ages) { //placeHolder
    println("the key is " + k)
  }

  val map = Map("Mac" -> 27, "Book" -> 15, "Silver" -> 5)
  for ((k, v) <- map) yield (k, v * 0.9)


  val scores = scala.collection.mutable.SortedMap("Mac" -> 27, "Book" -> 15, "Silver" -> 5)
  val bookScore = scores.getOrElse("Book", 0) // 有则直接返回key 对应的 value ,没有则返回 0

  scores += ("R" -> 9)
  scores -= ("Book")

  val imuScores = scala.collection.immutable.SortedMap("Mac" -> 27, "Book" -> 15, "Silver" -> 5)

  val tuple = (1, 1, 2, 3.14, 9, "Spark", "Hadoop", "Scala")

  val forth = tuple._4
  val forthWithoutPoint = tuple _4

  val (first, second, third, fortha, fifth, sixth, seventh, eighth) = tuple

  val (f, sec, _, _, _, _, _, _) = tuple

  "Scala Spark".partition(_.isUpper)

  // zip
  val symbol = Array("[", "-", "]")
  val counts = Array(1, 5, 1)// 对应的符号打印次数
  val pair = symbol.zip(counts)
  for ((x, y) <- pair) Console.println(x * y)


}