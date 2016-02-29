import expressions._

/**
  * Created by igor on 28-2-16.
  */
object PatternMatching extends App{
  val f = new ExpressionFormatter

  val expr =
    BinOp("/",
      BinOp("*", Var("x"),
        BinOp("+", Number(1), Var("y"))),
      BinOp("*",
        Var("z"),
        UnOp("-", Number(9))))

  val ex1 = BinOp("/", Var("x"), BinOp("+", Var("x"), Number(1)))

  def showExpr(exprs : Expression*){
    for(x <- exprs){
      println(f format x)
      println("===================")
    }
  }

  showExpr(
    expr,
    ex1)

  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
                      BinOp("+", Var("x"), Number(1)))

  val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),
                      BinOp("/", Number(1.5), Var("x")))

  val e3 = BinOp("/", e1, e2)

  showExpr(e1, e2, e3)

  val z = BinOp("/", Var("x"), Var("xxx"))

  showExpr(z)
}
