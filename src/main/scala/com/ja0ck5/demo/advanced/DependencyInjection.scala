package com.ja0ck5.demo.advanced

/**
  * Created by Jack on 2017/12/6.
  */

trait Logger {
  def log(msg: String)
}

trait Auth {
  auth: Logger =>
  def act(msg: String): Unit = {
    log(msg)
  }
}

object DI extends Auth with Logger{
  override def log(msg: String): Unit = println(msg)
}

object DependencyInjection {

  def main(args: Array[String]): Unit = {
    DI.act("Hope u take that jump but don't fear the fall.")
  }

}
