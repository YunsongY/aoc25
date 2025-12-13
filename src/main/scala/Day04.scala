import utils.AoCApp
import scala.util.Try
import scala.annotation.tailrec

object Day04 extends AoCApp:
  override def day: Int = 4

  val directions: List[(Int, Int)] =
    List((0, 1), (0, -1), (-1, 0), (1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1))

  def parseInput(input: String): Vector[Vector[Char]] =
    input.linesIterator.map(s => s.toVector).toVector

  override def part1(input: String): Any =
    val graph = parseInput(input)
    val coords = for r <- graph.indices; c <- graph(0).indices yield (r, c)
    coords.count { (r, c) =>
      graph(r)(c) == '@' && {
        val neighbors = directions.count { (dr, dc) =>
          Try(graph(r + dr)(c + dc) == '@').getOrElse(false)
        }
        neighbors < 4
      }
    }

  override def part2(input: String): Any =
    def countRolls(graph: Vector[Vector[Char]]): Int =
      graph.map(_.count(_ == '@')).sum.toInt

    def removeRolls(graph: Vector[Vector[Char]]): (Vector[Vector[Char]], Int) =
      val (newGraph, cnt) = graph.indices.map { r =>
        val (newRow, rowCnt) = graph(r).indices.map { c =>
          val cell = graph(r)(c)
          if cell == '@' then
            val neighbors = directions.count { (dr, dc) =>
              Try(graph(r + dr)(c + dc) == '@').getOrElse(false)
            }
            if neighbors < 4 then ('.', 1)
            else ('@', 0)
          else ('.', 0)
        }.unzip
        (newRow.toVector, rowCnt.sum)
      }.unzip
      (newGraph.toVector, cnt.sum)

    @tailrec
    def loop(currentGraph: Vector[Vector[Char]]): Vector[Vector[Char]] =
      val (nextGraph, changes) = removeRolls(currentGraph)
      if changes == 0 then currentGraph
      else loop(nextGraph)

    val graph = parseInput(input)
    countRolls(graph) - countRolls(loop(graph))
