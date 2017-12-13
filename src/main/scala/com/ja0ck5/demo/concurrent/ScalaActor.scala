package com.ja0ck5.demo.concurrent

import akka.actor.Actor

//import scala.actors.Actor

/**
  * Created by Jack on 2017/12/11.
  */
object ScalaActor {

}

object FirstActor extends Actor{
/*  def act(): Unit ={
    for(i <- 1 to 10){
      println("Step:" + i)
      Thread.sleep(2000)
    }
  }*/

  override def receive: Receive = ???
}
