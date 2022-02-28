package aa_sum_tail_recursion

import scala.annotation.tailrec

object Main {

  import RecursiveFunctions._

  def main(args: Array[String]): Unit = {
    val listOfNumbers = List.range(1, 4) // List(1, 2, 3, Nil)
    println(sum(listOfNumbers))
    println(sumTailRecursive(listOfNumbers, 0))
  }
}

object RecursiveFunctions {

  def sum(numberList: List[Int]): Int = numberList match {
    case Nil =>
      Thread.currentThread().getStackTrace.foreach(println)
      0
    case head :: tail => head + sum(tail)
  }

  @tailrec
  def sumTailRecursive(numberList: List[Int], accumulator: Int): Int = numberList match {
    case Nil =>
      Thread.currentThread().getStackTrace.foreach(println)
      accumulator
    case head :: tail => sumTailRecursive(tail, head + accumulator)
  }
}
