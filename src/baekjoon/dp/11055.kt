package baekjoon.dp

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n)

    for (i in 0 until n) {
        dp[i] = maxOf(dp[i], numbers[i])
        for (j in i + 1 until n) {
            if (numbers[i] < numbers[j]) {
                dp[j] = maxOf(dp[j], dp[i] + numbers[j])
            }
        }
    }

    val answer = dp.maxOrNull()
    println(answer)
}