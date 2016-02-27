/**
  * Created by igor on 21-2-16.
  */
object Exceptions {
  def main(){
    val n = 3
    val half =
      if(n % 2 == 0)
        n / 2
      else
        error("n must be even")

    println(half)



  }

  def error(message : String) : Nothing =
    throw new RuntimeException(message)
}
