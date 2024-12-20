package id.puzikov.advent24.day1

import java.io.File
import kotlin.math.abs

/**
 * You haven't even left yet and the group of Elvish Senior Historians has already hit a problem: their list of locations to check is currently empty.
 * Eventually, someone decides that the best place to check first would be the Chief Historian's office.
 *
 * Upon pouring into the office, everyone confirms that the Chief Historian is indeed nowhere to be found.
 * Instead, the Elves discover an assortment of notes and lists of historically significant locations!
 * This seems to be the planning the Chief Historian was doing before he left. Perhaps these notes can be used to determine which locations to search?
 *
 * Throughout the Chief's office, the historically significant locations are listed not by name but by a unique number called the location ID.
 * To make sure they don't miss anything, The Historians split into two groups, each searching the office and trying to create their own complete list of location IDs.
 *
 * There's just one problem: by holding the two lists up side by side (your puzzle input), it quickly becomes clear that the lists aren't very similar.
 * Maybe you can help The Historians reconcile their lists?
 *
 * For example:
 *
 * 3   4
 * 4   3
 * 2   5
 * 1   3
 * 3   9
 * 3   3
 *
 */
fun main() {
    val input = File("src/main/resources/id/puzikov/advent24/day1/input.txt")
    val list1 = ArrayList<Int>()
    val list2 = ArrayList<Int>()
    input
        .readLines()
        .map { line -> line.split("   ") }
        .map { it[0] to it[1] }
        .forEach { pair -> list1.add(pair.first.toInt()).also { list2.add(pair.second.toInt()) } }
    val sorted1 = list1.sorted()
    val sorted2 = list2.sorted()
    val sum = sorted1.zip(sorted2).map { abs(it.first - it.second) }.sum()
    println(sum)
}
