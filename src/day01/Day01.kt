package day01

import readInput

fun main() {

    val increased = "increased"
    val decreased = "decreased"
    val na = "N/A - no previous measurement"

    fun List<Int>.countIncreased(): Int {
        val collection: MutableList<Pair<Int, String>> = mutableListOf()
        forEachIndexed { index, int ->
            val pair = if (index - 1 >= 0) {
                if (int > this[index - 1])
                    Pair(int, increased)
                else
                    Pair(int, decreased)
            } else {
                Pair(int, na)
            }
            collection.add(pair)
        }
        return collection.count { it.second == increased }
    }

    fun part1(input: List<String>): Int {
        val numbers = input.map { it.toInt() }

        return numbers.countIncreased()
    }

    fun List<Int>.groupTriple() = mapIndexed { index, int ->
        var triple: Triple<Int, Int, Int>? = null
        try {
            triple = Triple(this[index - 1], this[index], this[index + 1])
        } catch (e: Exception) {

        }
        triple
    }.filterNotNull().map {
        it.first + it.second + it.third
    }

    fun part2(input: List<String>): Int {
        val numbers = input.map { it.toInt() }

        return numbers.groupTriple().countIncreased()
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test", "01")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01", "01")
    println("Answer Part 1: ${part1(input)}")
    println("Answer Part 2: ${part2(input)}")
}
