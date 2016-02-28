import expressions._

/**
  * Created by igor on 28-2-16.
  */
object PatternMatching extends App{
  val expr =
    BinOp("/",
      BinOp("*", Var("x"),
        BinOp("+", Number(1), Var("y"))),
      BinOp("*",
        Var("z"),
        UnOp("-", Number(9))))

  println(ExpressionFormatter.format(expr))
}
