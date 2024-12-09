package id.puzikov.advent24.day1

import java.io.File

fun main() {
    val input = File("src/main/resources/id/puzikov/advent24/day1/part2/input.txt")
    val list1 = ArrayList<Int>()
    val list2 = ArrayList<Int>()
    input
        .readLines()
        .map { line -> line.split("   ") }
        .map { it[0] to it[1] }
        .forEach { pair -> list1.add(pair.first.toInt()).also { list2.add(pair.second.toInt()) } }
    val list2Counts = list2.groupingBy { it }.eachCount()
    val sum = list1.sumOf { it * (list2Counts[it] ?: 0) }
    println(sum)
}
