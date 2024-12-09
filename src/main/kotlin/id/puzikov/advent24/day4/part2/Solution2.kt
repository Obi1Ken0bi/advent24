package id.puzikov.advent24.day4.part2

import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path

/**
 * Represents a position in a 2D grid with x and y coordinates.
 */
data class Position(val x: Int, val y: Int) {
    /**
     * Returns diagonal neighbors in clockwise order: topLeft, topRight, bottomRight, bottomLeft
     */
    fun getDiagonalNeighbors(): List<Position> =
        listOf(
            Position(x - 1, y - 1), // topLeft
            Position(x - 1, y + 1), // topRight
            Position(x + 1, y + 1), // bottomRight
            Position(x + 1, y - 1) // bottomLeft
        )
}

/**
 * Represents a character in the X-MAS pattern search grid.
 */
sealed interface GridChar {
    val char: Char

    data object M : GridChar {
        override val char = 'M'
    }

    data object A : GridChar {
        override val char = 'A'
    }

    data object S : GridChar {
        override val char = 'S'
    }

    data class Other(override val char: Char) : GridChar

    companion object {
        fun from(char: Char): GridChar =
            when (char) {
                'M' -> M
                'A' -> A
                'S' -> S
                else -> Other(char)
            }
    }
}

/**
 * Represents the search grid with validation and access methods.
 */
class SearchGrid private constructor(private val grid: List<List<GridChar>>) {
    val rows: IntRange = grid.indices
    val cols: IntRange = grid.firstOrNull()?.indices ?: IntRange.EMPTY

    operator fun get(position: Position): GridChar? =
        when {
            position.x !in rows || position.y !in cols -> null
            else -> grid[position.x][position.y]
        }

    companion object {
        fun fromFile(path: Path): SearchGrid =
            File(path.toString())
                .readLines()
                .map { line -> line.map(GridChar::from) }
                .let(::SearchGrid)
    }
}

/**
 * Pattern matcher for finding X-MAS patterns in the grid.
 */
class XMASPatternMatcher(private val grid: SearchGrid) {
    /**
     * Finds all valid X-MAS patterns in the grid.
     * @return count of valid patterns found
     */
    fun findPatterns(): Int =
        grid.rows.sumOf { x ->
            grid.cols.count { y ->
                isValidPattern(Position(x, y))
            }
        }

    private fun isValidPattern(center: Position): Boolean {
        if (grid[center] != GridChar.A) return false

        val neighbors = center.getDiagonalNeighbors()
        val (topLeft, topRight, bottomRight, bottomLeft) = neighbors.map { grid[it] }

        return topLeft != null &&
            topRight != null &&
            bottomRight != null &&
            bottomLeft != null &&
            isValidDiagonalPair(topLeft, bottomRight) &&
            isValidDiagonalPair(topRight, bottomLeft)
    }

    private fun isValidDiagonalPair(first: GridChar, second: GridChar): Boolean =
        (first == GridChar.M && second == GridChar.S) ||
            (first == GridChar.S && second == GridChar.M)
}

/**
 * Main application class that orchestrates the X-MAS pattern search.
 */
class XMASSearchApplication(private val inputPath: Path) {
    fun execute() {
        val grid = SearchGrid.fromFile(inputPath)
        val matcher = XMASPatternMatcher(grid)
        val occurrences = matcher.findPatterns()

        println("🎄 Ho Ho Ho! Found $occurrences X-MAS patterns in the word search! 🎅")
    }
}

fun main() {
    val app = XMASSearchApplication(Path("src/main/resources/id/puzikov/advent24/day4/input.txt"))
    app.execute()
}
