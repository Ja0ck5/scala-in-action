package com.ja0ck5.demo.concurrent

import akka.actor.Actor
import akka.event.Logging

//import scala.actors.Actor

/**
  * Created by Jack on 2017/12/11.
  */
object ScalaActor {

}

object FirstActor extends Actor {

  val log = Logging(context.system, this)

  override def receive = {
    case "test" ⇒ log.info("received test")
    case _ ⇒ log.info("received unknown message")
  }
}
