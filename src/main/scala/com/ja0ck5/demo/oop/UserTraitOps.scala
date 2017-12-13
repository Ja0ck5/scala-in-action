package com.ja0ck5.demo.oop

/**
  * Created by Jack on 2017/10/28.
  */
class UserTraitOps {

}

trait Logger {
  def log(msg: String) {}

  //  def log(msg: String) // 抽象方法,没有方法体，继承当前 trait 必须有具体实现
}

class ConcreteLogger extends Logger with Cloneable { // 多个 trait 使用 with

  override def log(msg: String) = println("Concrete Log : " + msg)

  def concreteLog: Unit = {
    log("It's a concrete log!!!")
  }

}


trait TraitLogger extends Logger {

  override def log(msg: String): Unit = println("TraitLogger Log content is : " + msg)

}


trait TraitLoggered {
  def logged(msg: String): Unit = {
    println("TraitLoggered Log content is : " + msg)
  }
}

trait ConsoleLogger extends TraitLogger {

  override def log(msg: String): Unit = {
    println("Log from Console : " + msg)
  }

}

class Test extends ConsoleLogger {
  def test: Unit = {
    log("Here is Scala!!!")
  }
}

abstract class Account {
  def save
}

object UserTraitOps extends App {
  // 1
  //  val logger = new ConcreteLogger with TraitLogger
  //  val logger = new ConcreteLogger
  //  logger.concreteLog

  // 2
  //  val t1 = new PianoTeacher
  //  t1.playPiano
  //  t1.teach

  //  val t2 = new Human with TTeacher with PianoPlayer {
  //    override def teach: Unit = println("I'm teaching students.")
  //  }
  //  t2.playPiano
  //  t2.teach

  // 3 AOP
  val work = new Work with TBeforeAfter
  work.doAction
}


class Human {
  println("Human")
}

trait TTeacher extends Human {
  println("TTeacher")

  def teach
}

trait PianoPlayer extends Human {
  println("PianoPlayer")

  def playPiano = {
    println("I'm playing piano.")
  }
}

class PianoTeacher extends Human with TTeacher with PianoPlayer {
  override def teach: Unit = {
    println("I'm training students.")
  }
}

// AOP
trait Action {
  def doAction
}

trait TBeforeAfter extends Action {
  abstract override def doAction: Unit = {
    println("Initialization")
    super.doAction
    println("Destroyed")
  }
}

class Work extends Action {
  override def doAction: Unit = println("Working...")
}