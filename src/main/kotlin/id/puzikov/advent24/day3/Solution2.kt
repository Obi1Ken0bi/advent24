package id.puzikov.advent24.day3

import java.io.File

private const val INPUT_PATH = "src/main/resources/id/puzikov/advent24/day3/input.txt"

fun main() {
    try {
        val input = File(INPUT_PATH).readText()
        val result = processMemory(input)
        println("Result: $result")
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        e.printStackTrace()
    }
}

private fun processMemory(input: String): Int {
    val mulPattern = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()

    val doPattern = """do\(\)""".toRegex()
    val dontPattern = """don't\(\)""".toRegex()

    data class Instruction(val type: String, val position: Int, val nums: Pair<Int, Int>? = null)

    val instructions = mutableListOf<Instruction>()

    mulPattern.findAll(input).forEach { match ->
        val (num1, num2) = match.destructured
        instructions.add(
            Instruction(
                type = "mul",
                position = match.range.first,
                nums = Pair(num1.toInt(), num2.toInt())
            )
        )
    }

    doPattern.findAll(input).forEach { match ->
        instructions.add(
            Instruction(
                type = "do",
                position = match.range.first
            )
        )
    }

    dontPattern.findAll(input).forEach { match ->
        instructions.add(
            Instruction(
                type = "dont",
                position = match.range.first
            )
        )
    }

    instructions.sortBy { it.position }

    var isEnabled = true
    var sum = 0

    instructions.forEach { instruction ->
        when (instruction.type) {
            "do" -> isEnabled = true
            "dont" -> isEnabled = false
            "mul" -> {
                if (isEnabled) {
                    val result = instruction.nums!!.first * instruction.nums.second
                    sum += result
                } else {
                    // do nothing
                }
            }
        }
    }

    return sum
}
