package functionsAndClosures

/**
  * Created by igor on 21-2-16.
  */
object MoreFunctions {
  def main(args: Array[String]){
    def function(name: String) = "function " + name

    val funcObj = function _

    println(function("as method"))

    println(funcObj("as function object"))

    def sum(a: Int, b: Int, c: Int) = "sum: " + (a + b + c)

    val sum2 = sum(1, _ : Int, 3)

    println(sum(1, 2, 3))
    println(sum2(2))


    var mutableState = "state: 0"

    val closure1 = (x : Int) => {
      mutableState += ", " + x
      mutableState}

    println(closure1(1))
    println(closure1(2))

    println("final state: " + mutableState)


    def multiArg(args: String*) =
      //args.toArray
      for(x <- args)yield x

    println(multiArg("a", "b", "c"))

    val strings = Array("d", "e", "f")

    println(multiArg(strings: _*))
    println(multiArg(multiArg(strings: _*) : _*))

    tailRecursion
  }

  private def tailRecursion{
    def boom(i : Int) : Int =
      if(i == 0)throw new RuntimeException("boom!")
      else boom(i - 1)// + 1 // Uncomment to demonstrate lack of tail recursion. Compare the exception stack trace

    boom(6)
  }
}
