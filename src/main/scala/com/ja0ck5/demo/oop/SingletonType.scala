package com.ja0ck5.demo.oop

class Animal {
  def breath:
  this.type = this
}

class Cat extends Animal {
  def eat: this.type = this
}

object SingletonType {
  val cat = new Cat
  cat.breath.eat
}
