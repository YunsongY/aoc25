import munit.FunSuite

class Day04Spec extends FunSuite:
  val exampleInput =
    """
    |..@@.@@@@.
    |@@@.@.@.@@
    |@@@@@.@.@@
    |@.@@@@..@.
    |@@.@@@@.@@
    |.@@@@@@@.@
    |.@.@.@.@@@
    |@.@@@.@@@@
    |.@@@@@@@@.
    |@.@.@@@.@.
    |""".stripMargin.trim

  test("Day 4 - Part 1 Example") {
    assertEquals(Day04.part1(exampleInput), 13)
  }

  test("Day 4 - Part 2 Example") {
    assertEquals(Day04.part2(exampleInput), 43)
  }
