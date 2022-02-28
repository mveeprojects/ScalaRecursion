package aa_sum_tail_recursion_tests

import org.scalatest.flatspec.AnyFlatSpec
import aa_sum_tail_recursion.RecursiveFunctions._

class SumRecursionSpec extends AnyFlatSpec {

  private val testList = List(1, 2, 3)

  "sum" should "calculate the sum of a list correctly" in {
    assert(sum(testList) == 6)
  }

  "sumTailRecursive" should "calculate the sum of a list correctly" in {
    assert(sumTailRecursive(testList, 0) == 6)
  }
}
