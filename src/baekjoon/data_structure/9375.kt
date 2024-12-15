package baekjoon.data_structure

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val n = readln().toInt()

        val map = mutableMapOf<String, Int>()
        for (j in 0 until n) {
            val (name, type) = readln().split(" ")
            map[type] = map.getOrDefault(type, 0) + 1
        }

        var answer = 1
        for(cnt in map.values) {
            answer *= (cnt + 1)
        }

        println(answer - 1)
    }
}
