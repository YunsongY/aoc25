import munit.FunSuite

class Day03Spec extends FunSuite:
  val exampleInput =
    """
    |987654321111111
    |811111111111119
    |234234234234278
    |818181911112111
    |""".stripMargin.trim

  test("Day 3 - Part 1 Example") {
    assertEquals(Day03.part1(exampleInput), 357)
  }

  test("Day 3 - Part 2 Example") {
    assertEquals(Day03.part2(exampleInput), 3121910778619L)
  }
