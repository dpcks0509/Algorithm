package baekjoon.dp

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n) { 1 }

    for (i in 0 until n) {
        for(j in 0 until i) {
            if(arr[i] > arr[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    bw.write("${dp.maxOrNull()}")
    bw.flush()
}
