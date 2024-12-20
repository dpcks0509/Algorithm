package baekjoon.dp

fun main() {
    val n = readln().toInt()
    val triangle = Array(n) { readln().split(" ").map { it.toInt() } }

    val dx = listOf(1, 1)
    val dy = listOf(0, 1)
    val dp = Array(n) { IntArray(it + 1) }
    dp[0][0] = triangle[0][0]

    for (x in 0 until n) {
        for (y in 0..x) {
            for (k in 0 until 2) {
                val nx = x + dx[k]
                val ny = y + dy[k]

                if (nx !in 0 until n || ny !in 0 until n) continue

                dp[nx][ny] = maxOf(dp[nx][ny], dp[x][y] + triangle[nx][ny])
            }
        }
    }

    println(dp[n - 1].maxOrNull())
}
