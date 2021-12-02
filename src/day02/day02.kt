package day01

import readInput

fun main() {

    fun List<String>.listToPair() = flatMap { it.split(" ") }
        .chunked(2)
        .map { Pair(it[0], it[1]) }

    fun part1(input: List<String>): Int {
        var position = 0
        var depth = 0

        input.listToPair()
            .forEach {
                when (it.first) {
                    "forward" -> position += it.second.toInt()
                    "down" -> depth += it.second.toInt()
                    "up" -> depth -= it.second.toInt()
                }
            }

        return position * depth
    }

    fun part2(input: List<String>): Int {
        var position = 0
        var depth = 0
        var aim = 0

        input.listToPair()
            .forEach {
                when (it.first) {
                    "forward" -> {
                        position += it.second.toInt()
                        depth += aim * it.second.toInt()
                    }
                    "down" -> aim += it.second.toInt()
                    "up" -> aim -= it.second.toInt()
                }
            }

        return position * depth
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println("Answer Part 1: ${part1(input)}")
    println("Answer Part 2: ${part2(input)}")
}
