/**
  * Created by igor on 20-2-16.
  */
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum() = ~(sum & 0xFF) + 1
}

import scala.collection.mutable.Map

object ChecksumAccumulator{
  private val cache = Map[String, Int]()

  def calculate(s : String) =
    if(cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for(c <- s)
        acc.add(c.toByte)

      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}