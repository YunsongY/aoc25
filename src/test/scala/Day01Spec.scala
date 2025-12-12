import munit.FunSuite

class Day01Spec extends FunSuite:
  val exampleInput =
    """
    |L68
    |L30
    |R48
    |L5
    |R60
    |L55
    |L1
    |L99
    |R14
    |L82
    |""".stripMargin.trim

  test("Day 1 - Part 1 Example") {
    assertEquals(Day01.part1(exampleInput), 3)
  }

  test("Day 1 - Part 2 Example") {
    assertEquals(Day01.part2(exampleInput), 6)
  }
