/**
  * Created by igor on 21-2-16.
  */
object Iterations {
  def main() {
    for (i <- 1 to 4)
      println("Iteration: " + i)

    for (i <- 1 until 4)
      println("Iteration: " + i)


    for(i <- 1 to 4 if i % 2 == 0)
      println("Even: " + i)

    val newSequence = for{
      i <- 1 to 4 if i % 2 == 0
      j = i + 1
    } yield j

    for(i <- newSequence)
      println(i)
  }
}
