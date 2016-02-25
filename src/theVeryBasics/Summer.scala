/**
  * Created by igor on 20-2-16.
  */

import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]){
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}
