package compositionAndInheritance

/**
  * Created by igor on 22-2-16.
  */
object AdHocEntryPoint {
  def main(args: Array[String]): Unit ={
    class A{
      val p = 11
      def p1 = "zzz"
      def notPure() = {
        println("side effect")

        "!pure"
      }
    }

    val aa = new A
    println(aa.p)
    //println(aa.p())

    println(aa.p1)
    //println(aa.p1())

    println(aa.notPure)
    println(aa.notPure())


    abstract class AC1{
      def doSomethingAbstract
      def doSomethingPure : String
    }

    abstract class Base1{
      val property1 = 1
      def property2 : String
      val value1 = "val1"
      def action()
    }

    class Base1Impl extends Base1{
      override val property1 = 2
      def action(){"Sends this string to /dev/null"}
      def property2 = "qqqq"
    }
  }
}
