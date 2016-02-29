package expressions

/**
  * Created by igor on 28-2-16.
  */
sealed abstract class Expression
case class Var(name: String) extends Expression
case class Number(val x: Double) extends Expression
case class UnOp(operator: String, arg: Expression) extends Expression{
  val z = "UnOp: " + operator + "(" +arg + ")"
}
case class BinOp(operator: String, left:Expression, right: Expression) extends Expression

