/**
  * Created by igor on 20-2-16.
  */
import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {
  for(season <- List("fall", "winter", "summer"))
    println(season + ": " + calculate(season))
}
