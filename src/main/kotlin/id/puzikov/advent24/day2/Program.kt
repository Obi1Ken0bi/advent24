package id.puzikov.advent24.day2

import java.io.File
import kotlin.math.abs

fun main() {
    val inputFile = File("src/main/resources/id/puzikov/advent24/day2/input.txt")
    val reports = inputFile.readLines().map { report -> report.split(" ").map { it.toInt() } }
    val res =
        reports
            .map { report ->
                print(report)
                val correctReport = isCorrectReport(report)
                println(" $correctReport")
                correctReport
            }.count { it }
    println(res)
}

private fun isCorrectReport(levels: List<Int>): Boolean =
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
