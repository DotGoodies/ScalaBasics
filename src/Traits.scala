import theVeryBasics.Rational

/**
  * Created by igor on 26-2-16.
  */
object Traits {

  trait Philosophical{
    def philosophize(){
      println("I consume memory, therefore I am!")
    }
  }

  class Animal

  trait HasLegs

  class Frog extends Animal with Philosophical with HasLegs{
    override def toString = "green"

    override def philosophize(){
      println("It ain't easy being " + toString + "!")
    }
  }

  class Point(val x: Int, val y : Int)

  trait Rectangular{
    def topLeft : Point
    def bottomRight : Point

    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
  }

  abstract class Component extends Rectangular

  class Rectangle(val topLeft: Point, val bottomRight : Point)
    extends Rectangular

  def main(){
    val frog = new Frog

    frog.philosophize()

    val r1 = new Rational(1, 2)
    val r2 = new Rational(3, 4)

    println(r1 < r2)
    println(r1 > r2)
    println(r1 >= r2)
    println(r1 <= r2)
    println(r1 == r2)

    val queue = new BasicIntQueue with Doubling with Incrementing with Filtering
    queue.put(10)
    println(queue.get())
  }
}
