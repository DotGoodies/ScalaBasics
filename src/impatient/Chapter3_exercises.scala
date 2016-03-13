package impatient

/**
  * Created by igor on 13-3-16.
  */
object Chapter3_exercises extends App {

  def swapElements(arr : Array[Int]) =
  for(i <- arr.indices) yield{
    if(i == arr.length - 1)arr(i)
    else if (i%2 == 0) arr(i+1)
    else arr(i-1)
  }

  swapElements(Array(1,2,3,4,5))

  def printProperties(): Unit = {
    import scala.collection.JavaConversions._
    val props : Map[String, String] =  java.lang.System.getProperties.toMap

    val longest = (for((n, _) <- props)yield{n.length}).max

    val x =for((n, v) <- props)yield{
      n.replace("\n", "~n").padTo(longest + 10, " ").mkString("") + "|" + v
    }

    for(line <- x)println(line)
  }

  printProperties()

}
