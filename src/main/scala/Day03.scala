import utils.AoCApp

object Day03 extends AoCApp:
  override def day: Int = 3

  val Command = """(\d+)-(\d+)""".r
  val keepCount = 12

  def parseInput(input: String): List[Vector[Int]] =
    input.linesIterator
      .filter(_.nonEmpty)
      .map(s => s.map(_.asDigit).toVector)
      .toList

  override def part1(input: String): Any =
    parseInput(input)
      .map(vec =>
        vec.tails
          .filter(_.length >= 2)
          .map { case head +: tail =>
            head * 10 + tail.max
          }
          .maxOption
          .getOrElse(0)
      )
      .sum

  override def part2(input: String): Any =
    parseInput(input)
      .map(vec =>
        vec
          .foldLeft((List.empty[Int], vec.size - keepCount)) {
            case ((curStack, dropLeft), digit) =>
              var s = curStack
              var d = dropLeft
              while (d > 0 && s.nonEmpty && s.head < digit) {
                s = s.tail
                d -= 1
              }
              (digit :: s, d)
          }
          ._1
          .reverse
          .take(keepCount)
          .foldLeft(0L)((acc, d) => acc * 10 + d)
      )
      .sum
