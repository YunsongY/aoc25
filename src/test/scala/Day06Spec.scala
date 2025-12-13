import munit.FunSuite

class Day06Spec extends FunSuite:
  val exampleInput =
    """
    |123 328  51 64 
    | 45 64  387 23 
    |  6 98  215 314
    |*   +   *   + 
    """.stripMargin.trim

  test("Day 6 - Part 1 Example") {
    assertEquals(Day06.part1(exampleInput), 4277556)
  }

  test("Day 6 - Part 2 Example") {
    assertEquals(Day06.part2(exampleInput), 3263827)
  }
