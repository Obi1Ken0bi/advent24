package id.puzikov.advent24.day2

import java.io.File
import kotlin.math.abs

/**
 *
 *    - The levels are either all increasing or all decreasing.
 *    - Any two adjacent levels differ by at least one and at most three.
 * How many reports are safe?
 */
fun main() {
    val inputFile = File("src/main/resources/id/puzikov/advent24/day2/input.txt")
    val reports = inputFile.readLines().map { report -> report.split(" ").map { it.toInt() } }
    val res = reports.count { isCorrectReport(it) }
    println(res)
}

fun isCorrectReport(levels: List<Int>): Boolean =
    if (levels.size < 2) {
        true
    } else {
        val isAscending = levels[1] > levels[0]
        levels.zipWithNext().all { (prev, curr) ->
            val diff = abs(curr - prev)
            diff in 1..3 &&
                (isAscending && curr >= prev || !isAscending && curr <= prev)
        }
    }
