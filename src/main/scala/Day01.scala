import utils.AoCApp

object Day01 extends AoCApp:
  override def day: Int = 1

  val Command = """([LR])(\d+)""".r
  val NumCount = 100
  override def part1(input: String): Any =
    val vals = input.linesIterator.map {
      case Command("L", n) => -n.toInt
      case Command("R", n) => n.toInt
      case _               => 0
    }.toList
    val (_, zeroCount) = vals.foldLeft((50, 0)) { case ((acc, times), v) =>
      val newAcc = ((acc + v) % NumCount + NumCount) % NumCount
      val newTimes = if newAcc == 0 then times + 1 else times
      (newAcc, newTimes)
    }
    zeroCount

  override def part2(input: String): Any =
    val vals = input.linesIterator.map {
      case Command("L", n) => -n.toInt
      case Command("R", n) => n.toInt
      case _               => 0
    }.toList
    val (_, zeroCount) = vals.foldLeft((50, 0)) {
      case ((currAbsPos, count), move) =>
        val nextAbsPos = currAbsPos + move

        val crossings =
          if move > 0 then
            Math.floorDiv(nextAbsPos, NumCount) - Math.floorDiv(
              currAbsPos,
              NumCount
            )
          else
            Math.floorDiv(currAbsPos - 1, NumCount) - Math.floorDiv(
              nextAbsPos - 1,
              NumCount
            )

        (nextAbsPos, count + crossings)
    }
    zeroCount
