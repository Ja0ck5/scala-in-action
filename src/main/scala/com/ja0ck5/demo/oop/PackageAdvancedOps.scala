package main.scala.oop

package spark {
  package navigation {

    private[spark] class Navigator {
      protected[navigation] def useStartChart() {}

      class LegOfJourney {
        private[Navigator] val distance = 100
      }

      private[this] var speed = 200
    }

  }

  package launch {

    import navigation._

    object Vehicle {
      private[launch] val guide = new Navigator
    }

  }

}

class PackageAdvancedOps {

  import PackageAdvancedOps.power

  private def canMakeItTrue = power > 10001
}

object PackageAdvancedOps {
  private def power = 10000

  def makeItTrue(p: PackageAdvancedOps): Boolean = {
    val result = p.canMakeItTrue
    result
  }
}
