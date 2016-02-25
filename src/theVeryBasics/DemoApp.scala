/**
  * Created by igor on 19-2-16.
  */

class Point2D(val x : Int, val y: Int){
 def move(dx: Int, dy: Int) = new Point2D(x + dx, y + dy)
 def +(dx: Int, dy: Int) = move(dx, dy)
 def -(dx: Int, dy: Int) = this.+(-dx, -dy)
 def +(dx: Int) : Point2D = this.+(dx, 0)
}


object DemoApp extends App{
 override def main(args: Array[String]) { Console.println("Hello world") }
}
