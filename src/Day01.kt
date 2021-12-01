fun main() {

    val increased = "increased"
    val decreased = "decreased"
    val na = "N/A - no previous measurement"

    fun part1(input: List<String>): Int {
        val numbers = input.map { it.toInt() }

        val collection: MutableList<Pair<Int, String>> = mutableListOf()
        numbers.forEachIndexed { index, int ->
            val pair = if (index - 1 >= 0) {
                if (int > numbers[index - 1])
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

    fun part2(input: List<String>): Int {
        val numbers = input.map { it.toInt() }

        return 0
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 0)

    val input = readInput("Day01")
    println("Answer Part 1: ${part1(input)}")
    println("Answer Part 2: ${part2(input)}")
}
