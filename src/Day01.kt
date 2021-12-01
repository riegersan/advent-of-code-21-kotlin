fun main() {
    fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
        val complements = associateBy { sum - it }
        return firstNotNullOfOrNull { number ->
            val complement = complements[number]
            if (complement != null) Pair(number, complement) else null
        }
    }

    fun List<Int>.findTripleOfSum() = firstNotNullOfOrNull { x ->
        val pair = findPairOfSum(2020 - x)
        if (pair != null) Triple(x, pair.first, pair.second) else null
    }

    fun part1(input: List<String>): Int? {
        val numbers = input.map { it.toInt() }

        val pair = numbers.findPairOfSum(2020)

        return pair?.let { (x,y) -> x*y }
    }

    fun part2(input: List<String>): Int? {
        val numbers = input.map { it.toInt() }

        val triple = numbers.findTripleOfSum()

        return triple?.let { (x,y,z) -> x*y*z }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 514579)
    check(part2(testInput) == 241861950)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
