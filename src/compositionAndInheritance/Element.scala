package compositionAndInheritance

/**
  * Created by igor on 22-2-16.
  */
abstract class Element {
  def contents : Array[String]
  val height = contents.length
  val width =
    if(height == 0) 0 else contents(0).length

  def above(other : Element) =
    new ArrayElement(contents ++ other.contents)

  def beside(other: Element) = {
    val contents = new Array[String](this.contents.length)
    for(i <- 0 until this.contents.length)
      contents(i) = this.contents(i) + other.contents(i)

    new ArrayElement(contents)
  }
}

class ArrayElement_(elements : Array[String]) extends Element{
  def contents = elements
}

class ArrayElement(val contents : Array[String]) extends Element

class LineElement
(
  val value: String
) extends Element{
  val contents = Array(value)
  override val width = contents.length
  override val height = 1
}

class UniformElement
(
  val ch: Char,
  override val width : Int,
  override val height : Int
) extends Element{
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}