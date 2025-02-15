package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    data class Score(val name: String, val korean: Int, val english: Int, val math: Int)

    val scores = Array(n) {
        val input = br.readLine().split(" ")
        Score(input[0], input[1].toInt(), input[2].toInt(), input[3].toInt())
    }

    val answer = scores.sortedWith(compareByDescending<Score> { it.korean }
        .thenBy { it.english }
        .thenByDescending { it.math }
        .thenBy { it.name })

    answer.forEach {
        println(it.name)
    }
}