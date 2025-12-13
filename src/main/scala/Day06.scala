import utils.AoCApp

object Day06 extends AoCApp:
  override def day: Int = 6

  def parseInput(input: String): (Vector[String], Vector[(Char, Int, Int)]) =
    val lines = input.linesIterator
      .filter(_.nonEmpty)
      .toVector

    val operators =
      lines.last.zipWithIndex.filterNot(_._1.isWhitespace).toVector
    val endIndices = operators.map(_._2).tail :+ lines(0).size
    val operatorsWithIndex = operators.zip(endIndices).map {
      case ((op, start), end) => (op, start, end)
    }

    (lines.init, operatorsWithIndex)

  override def part1(input: String): Any =
    val (numbers, operators) = parseInput(input)
    operators.map { case (op, start, end) =>
      val verticalList = numbers.map { case s =>
        s.substring(start, end).trim().toLong
      }.toList
      if op == '+' then verticalList.foldLeft(0L) { (acc, d) => acc + d }
      else verticalList.foldLeft(1L) { (acc, d) => acc * d }
    }.sum

  override def part2(input: String): Any =
    val (numbers, operators) = parseInput(input)
    operators.map { case (op, start, end) =>
      val verticalList = start
        .to(end - 1)
        .map { r =>
          numbers.map(_(r)).filterNot(_.isWhitespace).mkString
        }
        .filterNot(_.isEmpty)
        .map(_.toLong)
      if op == '+' then verticalList.foldLeft(0L) { (acc, d) => acc + d }
      else verticalList.foldLeft(1L) { (acc, d) => acc * d }
    }.sum
