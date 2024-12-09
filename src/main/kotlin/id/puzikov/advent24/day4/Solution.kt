// 🎄 Advent of Code 2024 - Day 4: Ceres Search 🎄
// Task: Find all occurrences of "XMAS" in any direction (horizontal, vertical, diagonal, even backwards!)
package id.puzikov.advent24.day4

import java.io.File

// 🎁 Input file path containing our festive word search puzzle
private const val INPUT_PATH = "src/main/resources/id/puzikov/advent24/day4/input.txt"

// 🎯 Represents a direction of movement in the matrix
private data class Direction(val dx: Int, val dy: Int) {
    // 🛷 Calculate next point in this direction
    fun next(point: Point) = Point(point.x + dx, point.y + dy)
}

// 🌟 Represents a position in our word search grid
private data class Point(val x: Int, val y: Int) {
    // 🎪 Check if this point is within matrix boundaries
    fun isValidFor(matrix: Matrix) = x in matrix.rows && y in matrix.cols
}

// 🎭 Wrapper class for our word search grid
private class Matrix(private val data: List<CharArray>) {
    val rows = data.indices
    val cols = data.firstOrNull()?.indices ?: IntRange.EMPTY

    // 🎨 Get character at given point
    operator fun get(point: Point) = data[point.x][point.y]

    companion object {
        // 🎅 Create matrix from input file
        fun fromFile(path: String) = Matrix(File(path).readLines().map { it.toCharArray() })
    }
}

// 🎁 Factory for creating all possible movement directions
private object DirectionsFactory {
    // ⭐ Four basic directions (up, down, left, right)
    val orthogonal =
        listOf(
            Direction(-1, 0), // Up like Santa climbing up a chimney
            Direction(1, 0), // Down like snow falling
            Direction(0, -1), // Left like elves marching
            Direction(0, 1) // Right like reindeer prancing
        )

    // 🌟 Four diagonal directions
    val diagonal =
        listOf(
            Direction(-1, -1), // Top-Left like a star's twinkle
            Direction(-1, 1), // Top-Right like a Christmas tree top
            Direction(1, -1), // Bottom-Left like wrapped presents
            Direction(1, 1) // Bottom-Right like Santa's sleigh path
        )

    // 🎄 All eight directions combined
    val all = orthogonal + diagonal
}

// 🎊 Class to find all occurrences of our target sequence
private class SequenceFinder(private val targetSequence: String) {
    // 🔍 Find all occurrences of the sequence in the matrix
    fun findOccurrences(matrix: Matrix): Int =
        matrix.rows.sumOf { x ->
            matrix.cols.sumOf { y ->
                DirectionsFactory.all.count { direction ->
                    checkSequence(Point(x, y), direction, matrix)
                }
            }
        }

    // 🎯 Recursively check if sequence exists starting from a point in given direction
    private fun checkSequence(
        start: Point,
        direction: Direction,
        matrix: Matrix,
        position: Int = 0
    ): Boolean {
        if (position == targetSequence.length) return true
        if (!start.isValidFor(matrix)) return false
        if (matrix[start] != targetSequence[position]) return false

        return checkSequence(direction.next(start), direction, matrix, position + 1)
    }
}

// 🎆 Main function to solve the puzzle
fun main() {
    val matrix = Matrix.fromFile(INPUT_PATH)
    val finder = SequenceFinder("XMAS") // 🎄 Looking for Christmas!
    val occurrences = finder.findOccurrences(matrix)
    println("🎅 Ho Ho Ho! Found $occurrences occurrences of XMAS in the word search! 🎄")
}
