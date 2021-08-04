import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    val listOfNumbers = List.range(1, 4) // List(1, 2, 3, Nil)
    println(sum(listOfNumbers))
    println(sumTailRecursive(listOfNumbers, 0))
  }

/*
*** Thread output of sum() ***
Main$.sum(Main.scala:12)
Main$.sum(Main.scala:14)
Main$.sum(Main.scala:14)
Main$.sum(Main.scala:14)
Main$.main(Main.scala:6)
Main.main(Main.scala)
6
*/
  def sum(numberList: List[Int]): Int = numberList match {
    case Nil =>
      Thread.currentThread().getStackTrace.foreach(println)
      0
    case head :: tail => head + sum(tail)
  }

/*
*** Thread output of sumTailRecursive() ***
Main$.sumTailRecursive(Main.scala:30)
Main$.main(Main.scala:7)
Main.main(Main.scala)
6
*/
  @tailrec
  def sumTailRecursive(numberList: List[Int], accumulator: Int): Int = numberList match {
    case Nil =>
      Thread.currentThread().getStackTrace.foreach(println)
      accumulator
    case head :: tail => sumTailRecursive(tail, head + accumulator)
  }
}
