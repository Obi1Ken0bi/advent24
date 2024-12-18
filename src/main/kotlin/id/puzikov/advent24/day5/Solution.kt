package id.puzikov.advent24.day5

// Extension function to parse input lines into pairs
private fun String.toPagePair(): Pair<Int, Int> = split("|").let { (x, y) -> x.toInt() to y.toInt() }

// Extension function to parse comma-separated pages
private fun String.toPages(): List<Int> = split(",").map { it.toInt() }

// Data class to represent the validation result
private data class ValidationResult(val isValid: Boolean, val middleValue: Int? = null)

fun main() {
    ClassLoader
        .getSystemResourceAsStream("id/puzikov/advent24/day5/input.txt")
        ?.bufferedReader(Charsets.UTF_8)
        ?.useLines { lines ->
            // Split input into dependencies and page sequences
            val (dependencies, pageSequences) =
                lines
                    .splitBy { it.isBlank() }
                    .take(2)
                    .toList()

            // Build page dependencies map
            val pageMap =
                dependencies
                    .map { it.toPagePair() }
                    .groupBy({ it.first }, { it.second })
                    .mapValues { it.value.toSet() }

            // Process each sequence and sum middle values of valid sequences
            pageSequences
                .asSequence()
                .map { it.toPages() }
                .map { validateAndGetMiddle(it, pageMap) }
                .filter { it.isValid }
                .mapNotNull { it.middleValue }
                .sum()
                .also { println(it) }
        }
}

// Extension function to split sequence by predicate
private fun Sequence<String>.splitBy(predicate: (String) -> Boolean): Sequence<List<String>> =
    sequence {
        var current = mutableListOf<String>()
        forEach { line ->
            if (predicate(line)) {
                if (current.isNotEmpty()) {
                    yield(current)
                    current = mutableListOf()
                }
            } else {
                current.add(line)
            }
        }
        if (current.isNotEmpty()) {
            yield(current)
        }
    }

private fun validateAndGetMiddle(pages: List<Int>, dependencies: Map<Int, Set<Int>>): ValidationResult {
    val seenPages = mutableSetOf<Int>()

    val isValid =
        pages.none { page ->
            val requiredPrecedingPages = dependencies[page] ?: emptySet()
            val hasRequiredPage = requiredPrecedingPages.any { it in seenPages }
            seenPages.add(page)
            hasRequiredPage
        }

    return if (isValid) {
        ValidationResult(
            isValid = true,
            middleValue = pages[pages.size / 2]
        )
    } else {
        ValidationResult(isValid = false)
    }
}
