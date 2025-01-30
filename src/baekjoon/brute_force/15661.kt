package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val team = BooleanArray(n) // true면 스타트팀, false면 링크팀

    var min = Int.MAX_VALUE

    fun difference(): Int {
        var start = 0
        var link = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (team[i] && team[j]) start += board[i][j]
                if (!team[i] && !team[j]) link += board[i][j]
            }
        }
        return kotlin.math.abs(start - link)
    }

    fun dfs(depth: Int, index: Int) {
        if (depth >= 1) {
            min = minOf(min, difference())
        }

        if (depth == n / 2) return

        for (i in index until n) {
            team[i] = true
            dfs(depth + 1, i + 1)
            team[i] = false
        }
    }

    dfs(0, 0)
    println(min)
}
