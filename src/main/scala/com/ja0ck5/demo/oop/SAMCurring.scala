package com.ja0ck5.demo.oop

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JButton, JFrame}

/**
  * SAM
  * Single Abstract Method
  */
object SAMCurring {

  def main(args: Array[String]): Unit = {
    var data = 0
    val frame = new JFrame("SAM Testing")
    val jButton = new JButton("Counter")
    jButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        data += 1
        println(data)
      }
    })


    implicit def convertedAction(action: (ActionEvent) => Unit): Unit = {
      new ActionListener {
        override def actionPerformed(e: ActionEvent): Unit = {
          action(e)
        }
      }
    }


    jButton.addActionListener((e: ActionEvent) => {
      data += 1
      println(data)
    })

    frame.setContentPane(jButton)
    frame.pack
    frame.setVisible(true)
  }
}
