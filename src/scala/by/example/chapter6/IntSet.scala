package scala.by.example.chapter6

/**
  * Created by igor on 10-3-16.
  */
trait IntSet {
  def incl(x: Int) : IntSet
  def contains(x: Int) : Boolean
  def isEmpty : Boolean

  def union(other: IntSet) : IntSet
  def intersect(other : IntSet) : IntSet
  def excl(x : Int) : IntSet

  def toList : List[Int]
}

class NonEmptySet(elem : Int, left: IntSet, right: IntSet) extends IntSet{
  def contains(x: Int) =
    if(x < elem) left.contains(x)
    else if(x > elem) right.contains(x)
    else true

  def incl(x: Int) =
    if(x < elem) new NonEmptySet(elem, left.incl(x), right)
    else if(x > elem) new NonEmptySet(elem, left, right.incl(x))
    else this

  def union(other: IntSet) = {
    val set = left union right union other

    set.incl(elem)
  }

  def intersect(other : IntSet) : IntSet = {
    val l = left.intersect(other)
    val r = right.intersect(other)
    val s = l union r

    if(other.contains(elem)) s.incl(elem) else s
  }

  def excl(x : Int) =
    if(x < elem) new NonEmptySet(elem, left.excl(x), right)
    else if ( x> elem)new NonEmptySet(elem, left, right.excl(x))
    else left.union(right)

  def isEmpty = false

  def toList = left.toList ::: List(elem) ::: right.toList
}

object EmptySet extends IntSet{
  def contains(x: Int) = false
  def incl(x:Int) = new NonEmptySet(x, EmptySet, EmptySet)

  def union(other : IntSet) = other
  def intersect(other : IntSet) : IntSet = this

  def excl(x: Int) = this

  def isEmpty = true

  def toList = List[Int]()
}
