/**
  * Created by igor on 20-2-16.
  */
class Rational(n : Int, d : Int){
  require(d != 0)

  private val g = findGreatestCommonDivisor(n.abs, d.abs)
  val numerator = n / g
  val denominator = d / g

  def this(n : Int) = this(n, 1)

  override def toString =
    if(denominator != 1)
      numerator + "/" + denominator
    else
      numerator.toString

  def + (other : Rational) = new Rational(
    numerator * other.denominator + other.numerator * denominator,
    denominator * other.denominator)

  def + (i : Int) = new Rational(numerator + i * denominator, denominator)

  def - (other : Rational) = new Rational(
    numerator * other.denominator - other.numerator * denominator,
    denominator * other.denominator)

  def - (i : Int) = new Rational(numerator - i * denominator, denominator)

  def * (other : Rational) = new Rational(numerator * other.numerator, denominator * other.denominator)

  def * (i : Int) = new Rational(numerator * i, denominator)

  def / (other : Rational) = new Rational(numerator * other.denominator, denominator * other.numerator)

  def / (i : Int) = new Rational(numerator, denominator * i)

  def lessThen(other : Rational) = numerator * other.denominator < other.numerator * denominator

  def max(other : Rational) = if(lessThen(other)) other else this

  private def findGreatestCommonDivisor(a : Int, b : Int) : Int =
    if(b == 0) a else findGreatestCommonDivisor(b, a % b)
}
