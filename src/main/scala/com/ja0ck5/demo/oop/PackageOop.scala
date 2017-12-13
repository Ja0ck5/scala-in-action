package main.scala.oop


package com.scala.spark

package object people {
  val defaultName = "Scala"
}

package people {

  class people {
    var name = defaultName // "Scala"
  }

}


import java.util.{HashMap => JavaHashMap}

class PackageOop {

}

package spark.navigation {

  abstract class Navigation {
    def act
  }
  package tests {

    // spark.navigation.tests
    class NavigatorSuite

  }

  package impl {

    class Action extends Navigation {
      override def act: Unit = {
        println("impl action......")
      }
    }

  }

}

package hadoop {
  package navigation {

    class Navigator

  }

  package launch {

    class Booster {
      val nav = new navigation.Navigator
    }

  }

}


object PackageOop {
  def main(args: Array[String]): Unit = {

  }
}