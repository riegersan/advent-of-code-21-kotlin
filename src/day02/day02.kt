package day01

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val numbers = input.map { it.toInt() }

        return 0
    }

    fun part2(input: List<String>): Int {
        val numbers = input.map { it.toInt() }

        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 0)
    check(part2(testInput) == 0)

    val input = readInput("Day02")
    println("Answer Part 1: ${part1(input)}")
    println("Answer Part 2: ${part2(input)}")
}
