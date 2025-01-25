fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val schedule = Array(n) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        t to p
    }

    val dp = IntArray(n + 1)

    for (i in 0 until n) {
        val (t, p) = schedule[i]

        if (i > 0) dp[i] = maxOf(dp[i], dp[i - 1])

        if (i + t <= n) {
            dp[i + t] = maxOf(dp[i + t], dp[i] + p)
        }
    }

    bw.write(dp.maxOrNull().toString())
    bw.flush()
    br.close()
    bw.close()
}
