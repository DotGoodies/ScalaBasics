package scala.by.example.chapter6

/**
  * Created by igor on 12-3-16.
  */
trait MyBoolean {
  def ifThenElse(thenPart : => MyBoolean, elsePart : => MyBoolean) : MyBoolean

  def && (x: => MyBoolean) : MyBoolean = ifThenElse(x, False)
  def || (x: => MyBoolean) : MyBoolean = ifThenElse(True, x)
  def unary_! : MyBoolean = ifThenElse(False, True)
}

case object False extends MyBoolean{
  def ifThenElse(thenPart : => MyBoolean, elsePart : => MyBoolean) = elsePart

  override def toString = "False"
}

case object True extends MyBoolean{
  def ifThenElse(thenPart : => MyBoolean, elsePart : => MyBoolean) = thenPart

  override def toString = "True"
}
