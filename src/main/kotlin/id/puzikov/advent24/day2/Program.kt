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

fun isCorrectReport(levels: List<Int>): Boolean {
    if (levels.size < 2) return true
    val asc = levels[1] > levels[0]
    for (i in (1..<levels.size)) {
        val curr = levels[i]
        val prev = levels[i - 1]
        val dif = abs(curr - prev)
        if (dif < 1 || dif > 3) {
            return false
        }
        if (asc) {
            if (curr < prev) {
                return false
            }
        } else {
            if (curr > prev) {
                return false
            }
        }
    }
    return true
}
