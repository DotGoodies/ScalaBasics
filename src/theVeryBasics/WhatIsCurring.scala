package controlStructures

/**
  * Created by igor on 22-2-16.
  */
object WhatIsCurring {
  def main(args: Array[String]){
    def plainOldSum(x : Int, y : Int) = x + y

    println(plainOldSum(2, 3))

    def curriedSum (x: Int)(y : Int) = x + y

    val sum1 = curriedSum(2) _

    println(sum1(3))

    def twice (op: Double => Double, x: Double) = op(op(x))

    println(twice(_ + 1, 5))

    println(twice(x => x + 1, 5))
  }
}
