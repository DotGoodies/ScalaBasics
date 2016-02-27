package compositionAndInheritance

/**
  * Created by igor on 22-2-16.
  */

import console.layout.Element._

object ElementEntryPoint extends App {
  val x1 = array("Hello", "z") above
    array("world!", "q")

  val x2 = array("one|", "two|") beside array("one", "x")

  println(x1 above x2)
  println("==========")
  println(x1 beside x2)

  val box1 = box('*', 4)
  val box2 = box('#', 4)

  val form = (box1 beside box2) above
    (box2 beside box1)

  println("==========")
  println(form)

  val box3 = box('*', 2)
  val box4 = box('#', 4)

  println("==========")
  println(box3 above box4)
  println("==========")
  println(box3 beside box4)

  println(Spiral.spiral(17, 0))
}
