package compositionAndInheritance

/**
  * Created by igor on 22-2-16.
  */

import Element.array

object ElementEntryPoint extends App {
  val x1 = array("Hello", "z") above array("world!", "q")
  val x2 = array("one", "two") beside array("one", "x")

  println(x1)
  println(x2)
}
