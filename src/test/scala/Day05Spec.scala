import munit.FunSuite

class Day05Spec extends FunSuite:
  val exampleInput =
    """
    |3-5
    |10-14
    |16-20
    |12-18
    |
    |1
    |5
    |8
    |11
    |17
    |32
    """.stripMargin.trim

  test("Day 5 - Part 1 Example") {
    assertEquals(Day05.part1(exampleInput), 3)
  }

  test("Day 4 - Part 2 Example") {
    assertEquals(Day05.part2(exampleInput), 14)
  }
