package controlStructures

import java.io.{PrintWriter, File}
import java.util.{Date, UUID}

/**
  * Created by igor on 22-2-16.
  */
object NewControlStructures {
  def main(args: Array[String]){
    println("arg")
    println{"Can use {} instead of () to pass parameter"}

    def sum(i : Int)(j : Int) = i + j

    println(sum(1)(2))

    println(sum(1){
      2
    })

    def withPrintWriter(file: File)(op: PrintWriter => Unit) {
      val writer = new PrintWriter(file)
      try {
        op(writer)
      } finally {
        writer.close()
      }
    }

    withPrintWriter(new File("/tmp/" + UUID.randomUUID()))    {
      writer => writer.println(new Date())
    }
  }
}
