import utils.AoCApp

object Day01 extends AoCApp:
  override def day: Int = 1

  extension (input: String)
    def parseToInts: List[Int] = 
      input.linesIterator.map(_.toInt).toList

  override def part1(input: String): Any =
    val nums = input.parseToInts
    nums.sum

  override def part2(input: String): Any =
    val nums = input.parseToInts
    nums.sliding(3).map(_.sum).count(_ > 0)