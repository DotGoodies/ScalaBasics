package impatient

/**
  * Created by igor on 13-3-16.
  */
object Chapter2_exercise_10 extends App{
  def pow(x: Double, n: Int): Double = {
    if(n < 0)1/pow(x, -n)

    else if(n == 0) 1

    else if (n % 2 != 0) x * pow(x, n-1)

    //That was a tricky one. Without this base case the next one loops on x^2 forever since x^1 = x
    //and thus next step pow(y, 2) enters the same branch again and again
    else if (n == 2) x*x

    else{
      val y = pow(x, n/2)
      pow(y, 2)
    }
  }

  pow(10, 3)
}
