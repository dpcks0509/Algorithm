package baekjoon.dp

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()

    val dp = Array<Long>(101) { 0 }
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    for (i in 4..100) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }

    for (i in 0 until n) {
        val p = br.readLine().toInt()
        bw.write("${dp[p]}\n")
    }

    bw.flush()
}
