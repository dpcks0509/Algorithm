package baekjoon.implementation

fun main() {
    data class Info(
        val time: Int,
        val height: Int,
    )

    val (n, m, b) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()

    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        input.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
    }

    val min = map.keys.minOrNull() ?: 0
    val max = map.keys.maxOrNull() ?: 0

    val information = mutableListOf<Info>()
    for (height in min..max) {
        val needToRemove = map.entries.filter { it.key > height }.sumOf { (it.key - height) * it.value }
        val needToAdd = map.entries.filter { it.key < height }.sumOf { (height - it.key) * it.value }

        val inventory = b + needToRemove
        if (inventory >= needToAdd) {
            val time = needToRemove * 2 + needToAdd
            information.add(Info(time, height))
        }
    }

    information.sortWith(compareBy({ it.time }, { -it.height }))
    val answer = information.first()
    println("${answer.time} ${answer.height}")
}
