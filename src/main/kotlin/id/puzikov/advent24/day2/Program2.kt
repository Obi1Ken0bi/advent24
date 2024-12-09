package id.puzikov.advent24.day2

import java.io.File
import kotlin.math.abs

fun main() {
    File("src/main/resources/id/puzikov/advent24/day2/input.txt")
        .readLines()
        .map { it.split(" ").map(String::toInt) }
        .onEach { report ->
            println("$report ${isCorrectReport(report)}")
        }.count(::isCorrectReport)
        .let(::println)
}

private fun isCorrectReport(levels: List<Int>, removedIndex: Int? = null): Boolean {
    if (levels.size < 2) return true

    val isAscending =
        levels.zipWithNext().count { (a, b) -> a < b } >
            levels.zipWithNext().count { (a, b) -> a > b }

    levels.zipWithNext().forEachIndexed { i, (curr, next) ->
        val invalidDiff = abs(next - curr) !in 1..3
        val wrongDirection = (isAscending && curr > next) || (!isAscending && curr < next)

        if (invalidDiff || wrongDirection) {
            return when {
                removedIndex != null -> false
                isCorrectReport(levels.toMutableList().apply { removeAt(i + 1) }, i + 1) -> true
                else -> isCorrectReport(levels.toMutableList().apply { removeAt(i) }, i)
            }
        }
    }

    return true
}
