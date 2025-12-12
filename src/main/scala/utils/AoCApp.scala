package utils

import scala.concurrent.duration.*

trait AoCApp:
  def day: Int

  def part1(input: String): Any
  def part2(input: String): Any

  def main(args: Array[String]): Unit =
    val filename = f"day$day%02d.txt"
    val inputFile = os.pwd / "input" / filename

    if !os.exists(inputFile) then
      println(s"❌ Input file not found: $inputFile")
      println(
        "   Please download the input file from the official website and place it in the input/ directory."
      )
      System.exit(1)

    val input = os.read(inputFile).trim

    println(s"=== 🎄 Advent of Code Day $day 🎄 ===")

    time("Part 1") { part1(input) }
    time("Part 2") { part2(input) }

  private def time(label: String)(block: => Any): Unit =
    val start = System.nanoTime()
    val result = block
    val end = System.nanoTime()
    val duration = (end - start).nanos.toMillis
    println(f"[$label] Result: $result%s ($duration ms)")
