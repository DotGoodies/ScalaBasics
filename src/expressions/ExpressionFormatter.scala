package expressions

import console.layout.Element
import console.layout.Element.elem

/**
  * Created by igor on 28-2-16.
  */
class ExpressionFormatter {
  private val operationGroups =
    Array(
      Set("+", "-"),
      Set("*")
    )

  private val precedence =  {
    for {
      i <- operationGroups.indices
      op <- operationGroups(i)
      }yield op -> i
  }.toMap

  private val unaryPrecedence = operationGroups.length
  private val fractionPrecedence = -1

  private def format(e: Expression, enclPrec: Int):Element = e match{
    case Var(name) =>
      elem(name)

    case Number(num) => elem{
      val st = num.toString
      if(st endsWith ".0")
        st.substring(0, st.length - 2)
      else st
    }

    case x @ UnOp(op, arg) => {
      println(x.z)
      elem(op) beside format(arg, unaryPrecedence)
    }

    case BinOp("/", left, right) =>
      val top = format(left, fractionPrecedence)
      val bot = format(right, fractionPrecedence)
      val line = elem('-', top.width max bot.width, 1)
      val frac = top above line above bot

      if(enclPrec != fractionPrecedence) frac
      else elem(" ") beside frac beside elem(" ")


    case BinOp(op, left, right) =>
      val opPrec = precedence(op)
      val l = format(left, opPrec)
      val r = format(right, opPrec)
      val oper = l beside elem(" " + op + " ") beside r

      if(enclPrec <= opPrec) oper
      else elem("(") beside oper beside elem(")")
  }

  def format(e: Expression): Element = format(e, 0)
}
