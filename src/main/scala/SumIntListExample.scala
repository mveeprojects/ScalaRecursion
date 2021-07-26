import scala.annotation.tailrec

object SumIntListExample extends App {

  val smallNumberListToSum = List.range(1, 10)
  val bigNumberListToSum   = List.range(1, 1000000)

  private def printStackTrace(): Unit = Thread.currentThread().getStackTrace.foreach(println)

  def simpleRecursion(): Unit = {
    def sum(list: List[Int]): Int = list match {
      case Nil =>
        printStackTrace()
        0
      case x :: xs => x + sum(xs)
    }
    println(sum(smallNumberListToSum))
//    println(sum(bigNumberListToSum))
  }

  def tailRecursion(): Unit = {
    def sum(list: List[Int]): Int = list match {
      case Nil => 0
      case x   => sumTailRecursive(x, 0)
    }

    @tailrec
    def sumTailRecursive(list: List[Int], accumulator: Int): Int = list match {
      case Nil =>
        printStackTrace()
        accumulator
      case x :: xs => sumTailRecursive(xs, x + accumulator)
    }

    println(sum(bigNumberListToSum))
  }

  simpleRecursion()
//  tailRecursion()
}
