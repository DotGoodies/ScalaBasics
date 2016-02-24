package compositionAndInheritance

object Element{
  def elem(contents : Array[String]) : Element = new ArrayElement(contents)
  def elem(value: String) : Element = new LineElement(value)
  def elem(ch: Char, width : Int, height : Int): Element =
    new UniformElement(ch, width, height)

  def array(value: String*): Element = new ArrayElement(value.toArray)

  def blank(width : Int, height : Int) : Element = new UniformElement(' ', width, height)

  def box(ch: Char, size: Int): Element = new UniformElement(ch, size, size)

  private class ArrayElement(val contents : Array[String]) extends Element

  private class LineElement
  (
    val value: String
  ) extends Element{
    val contents = Array(value)
    override val width = contents.length
    override val height = 1
  }

  private class UniformElement
  (
    val ch: Char,
    override val width : Int,
    override val height : Int
  ) extends Element{
    def contents = Array.fill(height){
      ch.toString * width
    }
  }
}

import Element.elem
import Element.blank

abstract class Element {
  def contents: Array[String]

  def width =
    if(height == 0) 0 else contents(0).length
  def height = contents.length

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = blank((w - width) / 2, height)
      val right = blank(w - width - left.width, height)

      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = blank(width, (h - height) / 2)
      val bottom = blank(width, h - height - top.height)

      top above this above bottom
    }

  def above(other: Element) = {
    val this1 = this widen other.width
    val other1 = other widen this.width
    elem(this1.contents ++ other1.contents)
  }

  def beside(other: Element) = {

    val this1 = this heighten other.height
    val other1 = other heighten this.height

    elem(
      for ((left, right) <- this1.contents zip other1.contents)
        yield left + right
    )
  }
  override def toString = contents mkString "\n"
}

