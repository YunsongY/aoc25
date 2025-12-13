import utils.AoCApp

object Day05 extends AoCApp:
  override def day: Int = 5

  def parseInput(input: String): (List[(Long, Long)], List[Long]) =
    val parts = input.split("\n\n")

    val ranges = parts(0).linesIterator.map { line =>
      val Array(start, end) = line.split("-")
      (start.toLong, end.toLong)
    }.toList

    val numbers = parts(1).linesIterator
      .filter(_.nonEmpty)
      .map(_.toLong)
      .toList

    (ranges, numbers)

  override def part1(input: String): Any =
    val (ranges, numbers) = parseInput(input)
    numbers.count { n =>
      ranges.exists { case (l, r) =>
        n >= l && n <= r
      }
    }

  override def part2(input: String): Any =
    val (ranges, _) = parseInput(input)
    val sortedRanges = ranges.sortBy(_._1)
    val mergedRanges = sortedRanges.foldLeft(List.empty[(Long, Long)]) {
      case (Nil, curr)                                        => List(curr)
      case ((lastStart, lastEnd) :: tail, (curStart, curEnd)) =>
        if curStart <= lastEnd + 1 then
          (lastStart, math.max(lastEnd, curEnd)) :: tail
        else (curStart, curEnd) :: (lastStart, lastEnd) :: tail
    }
    mergedRanges.map { case (s, e) => e - s + 1 }.sum
