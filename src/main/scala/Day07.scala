import utils.AoCApp

object Day07 extends AoCApp:
  override def day: Int = 7

  def parseInput(input: String): Vector[String] =
    input.linesIterator.toVector

  override def part1(input: String): Any =
    val graph = parseInput(input)
    val startIndex = graph(0).indexWhere(_ == 'S')
    val (_, totalSplits) = graph.tail.foldLeft((Set(startIndex), 0)) {
      case ((currentBeams, splitCount), rowStr) =>
        val (nextBeams, newSplits) =
          currentBeams.foldLeft((Set.empty[Int], 0)) {
            case ((next, cnt), col) =>
              if col >= 0 && col < rowStr.length then
                rowStr(col) match
                  case '^' => (next ++ Set(col - 1, col + 1), cnt + 1)
                  case _   => (next + col, cnt)
              else (next, cnt)
          }
        (nextBeams, splitCount + newSplits)
    }
    totalSplits

  override def part2(input: String): Any =
    val graph = parseInput(input)
    val startIndex = graph(0).indexWhere(_ == 'S')
    val initialBeams = Map(startIndex -> 1L)
    val finalBeams = graph.tail.foldLeft(initialBeams) {
      (currentBeams, rowStr) =>
        currentBeams.foldLeft(Map.empty[Int, Long].withDefaultValue(0L)) {
          case (nextMap, (col, count)) =>
            if col >= 0 && col < rowStr.length then
              rowStr(col) match
                case '^' =>
                  val left = col - 1
                  val right = col + 1
                  nextMap
                    .updated(left, nextMap(left) + count)
                    .updated(right, nextMap(right) + count)
                case _ =>
                  nextMap.updated(col, nextMap(col) + count)
            else nextMap
        }
    }
    finalBeams.values.sum
