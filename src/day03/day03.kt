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
        val oxygenRating = input.toMutableList()
        val carbonDioxidRating = input.toMutableList()

        var oxygen = ""

        input[0].forEachIndexed{ index, _ ->
            when {
                oxygenRating.count { it[index] == '0' } > oxygenRating.count { it[index] == '1' } -> {
                    oxygenRating.removeAll { it[index] == '1' }
                }
                else -> {
                    oxygenRating.removeAll { it[index] == '0' }
                }
            }
            if(oxygenRating.size == 1) oxygenRating[0].also { oxygen = it }
        }
        print("")

        var co2 = ""
        input[0].forEachIndexed{ index, _ ->
            when {
                carbonDioxidRating.count { it[index] == '0' } != carbonDioxidRating.count { it[index] == '1' } -> {
                    when {
                        carbonDioxidRating.count { it[index] == '0' } < carbonDioxidRating.count { it[index] == '1' } -> {
                            carbonDioxidRating.removeAll { it[index] == '1' }
                        }
                        else -> {
                            carbonDioxidRating.removeAll { it[index] == '0' }
                        }
                    }
                }
                else -> {
                    carbonDioxidRating.removeAll { it[index] == '1' }
                }
            }
            if(carbonDioxidRating.size == 1) carbonDioxidRating[0].also { co2 = it }
        }

        return Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2)
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println("Answer Part 1: ${part1(input)}")
    println("Answer Part 2: ${part2(input)}")
}
