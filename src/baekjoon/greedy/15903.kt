package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val numbers = LongArray(n)
    val input = br.readLine().split(" ").map { it.toLong() }
    for (i in 0 until n) {
        numbers[i] = input[i]
    }

    for (i in 0 until m) {
        numbers.sort()

        val sum = numbers[0] + numbers[1]
        numbers[0] = sum
        numbers[1] = sum
    }

    val answer = numbers.sum()
    println(answer)
}