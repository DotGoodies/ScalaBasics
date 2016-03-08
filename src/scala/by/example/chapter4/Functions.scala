package scala.by.example.chapter4

/**
  * Created by igor on 8-3-16.
  */
object Functions {
  def sqrt(x: Double) : Double = {
    def sqrt1(approxim: Double): Double = {
      val next = (approxim + x / approxim) / 2
      if((next - approxim).abs < 0.000001)
        next
      else
        sqrt1(next)
    }
    sqrt1(1)
  }

  def factorial(x: Int) : Int = {
    if(x == 0) 1
    else x * factorial(x - 1)
  }

  def factorialTail(x: Int) : Int = {
    def f2(fPrev: Int, nCurrent : Int):Int = {

      if(nCurrent > x) fPrev
      else {
        val fNext = nCurrent * fPrev
        f2(fNext, nCurrent + 1)
      }
    }

    if(x <= 1) 1 else f2(1, 1)
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + sum(f)(a+ 1, b)
  }

  def sumTail(f: Int => Int)(a: Int, b: Int) : Int = {
    def iter(a: Int, result: Int) : Int =
      if(a > b) result
      else iter(a + 1, f(a) + result)

    iter(a, 0)
  }

  def product(f: Int => Int)(a: Int, b: Int) : Int = {
    def iter(a: Int, result: Int) : Int =
      if(a > b) result
      else iter(a + 1, f(a) * result)

    iter(a, 1)
  }

  def factorialProduct(x: Int):Int = {
    product(x => x)(1, x)
  }

  def aggregate(f: Int => Int, initValue: Int, aggregator: (Int, Int) => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int) : Int =
      if(a > b) result
      else iter(a + 1, aggregator(f(a), result))

    iter(a, initValue)

  }

  val sumAgg = aggregate(x => x, 0, _ + _) _
}
