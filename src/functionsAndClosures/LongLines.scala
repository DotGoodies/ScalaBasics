package functionsAndClosures

/**
  * Created by igor on 21-2-16.
  */

import scala.io.Source

object LongLines {

  def processFile(fileName : String, width : Int){

    val prefix = "~"

    def processLine(line: String){
      if(line.length >= width)
        println(fileName + prefix + ": " + line.trim)
    }

    // def -> function object
    val pl = processLine _

    val source = Source.fromFile(fileName)

    for(line <- source.getLines())
//      processLine(fileName, line, width)
      pl(line)
  }

//  private def processLine(fileName: String, line: String, width: Int){
//    if(line.length >= width)
//      println(fileName + ": " + line.trim)
//  }
}
