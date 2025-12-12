import utils.AoCApp

object Day02 extends AoCApp:
  override def day: Int = 2

  val Command = """(\d+)-(\d+)""".r

  def parseInput(input: String): List[(Long, Long)] =
    input
      .split(",")
      .map { case Command(v1, v2) =>
        (v1.toLong, v2.toLong)
      }
      .toList

  override def part1(input: String): Any =
    parseInput(input)
      .map((v1, v2) =>
        v1.to(v2)
          .map(v =>
            val str = v.toString()
            if str.matches("^(.+)\\1$") then v else 0
          )
          .sum
      )
      .sum

  override def part2(input: String): Any =
    parseInput(input)
      .map((v1, v2) =>
        v1.to(v2)
          .map(v =>
            val str = v.toString()
            if str.matches("^(.+)\\1+$") then v else 0
          )
          .sum
      )
      .sum
