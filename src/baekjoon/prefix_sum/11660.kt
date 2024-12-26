package baekjoon.prefix_sum

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val input = readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 1..n) {
            board[i][j] = input[j - 1]
        }
    }

    val prefixSum = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        for (j in 1..n) {
            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + board[i][j]
        }
    }

    for (i in 0 until m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

        val answer = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1]
        println(answer)
    }
}