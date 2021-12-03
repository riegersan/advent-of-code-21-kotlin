package day03

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var gammaRate = ""
        var epsilonRate = ""

        input[0].forEachIndexed{ index, _ ->
            if(input.count { it[index] == '0' } > input.count { it[index] == '1' }){
                gammaRate +="0"
                epsilonRate +="1"
            }else{
                gammaRate +="1"
                epsilonRate +="0"
            }
        }

        return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)
    }

    fun part2(input: List<String>): Int {


        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 0)

    val input = readInput("Day03")
    println("Answer Part 1: ${part1(input)}")
    println("Answer Part 2: ${part2(input)}")
}
