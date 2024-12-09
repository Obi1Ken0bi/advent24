package id.puzikov.advent24.day3

import java.io.File

fun main() {
    val inputPath = "src/main/resources/id/puzikov/advent24/day3/input.txt"
    try {
        // Read input from file
        val input = File(inputPath).readText()
        val result = processMemory(input)
        println("Result: $result")
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        e.printStackTrace()
    }
}

private fun processMemory(input: String): Int {
    val pattern = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()

    val matches = pattern.findAll(input)

    return matches.sumOf { matchResult ->
        val (num1, num2) = matchResult.destructured
        val result = num1.toInt() * num2.toInt()
        result
    }
}
