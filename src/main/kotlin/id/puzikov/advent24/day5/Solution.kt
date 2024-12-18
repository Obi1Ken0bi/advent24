package id.puzikov.advent24.day5

fun main() {
    val reader = ClassLoader.getSystemResourceAsStream("id/puzikov/advent24/day5/input.txt").bufferedReader(Charsets.UTF_8)
    var line = reader.readLine()
    val xToYs = HashMap<Int, Set<Int>>()
    while (line.isNotBlank()) {
        val splitted = line.split("|")
        xToYs.merge(splitted[0].toInt(), setOf(splitted[1].toInt())) { t1, t2 -> t1 + t2 }
        line = reader.readLine()
    }
    var result = 0
    while (reader.ready()) {
        val pages =
            reader
                .readLine()
                .split(",")
                .map { it.toInt() }
                .toList()
        val seenPages = HashSet<Int>()
        val incorrect =
            pages.any { page ->
                val pagesShouldBeAfter = xToYs[page] ?: emptySet()
                val correct = pagesShouldBeAfter.any { seenPages.contains(it) }
                seenPages.add(page)
                correct
            }
        if (!incorrect) {
            val middleIdx = pages.size / 2
            val middlePage = pages[middleIdx]
            result += middlePage
        }
    }
    println(result)
}
