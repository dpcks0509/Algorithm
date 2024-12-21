package baekjoon.back_tracking

fun main() {
    val n = readln().toInt()

    val visited = Array(n) { BooleanArray(n) }
    var cnt = 0

    fun isPromising(
        x: Int,
        y: Int,
    ): Boolean {
        for (i in 0 until x) {
            //세로
            if (visited[i][y]) return false
            // 왼쪽위 대각선
            if (y - i - 1 >= 0 && visited[x - i - 1][y - i - 1]) return false
            // 오른쪽위 대각선
            if (y + i + 1 < n && visited[x - i - 1][y + i + 1]) return false
        }

        return true
    }

    fun backTracking(x: Int) {
        if (x == n) {
            cnt++
            return
        }

        for (y in 0 until n) {
            if (isPromising(x, y)) {
                visited[x][y] = true
                backTracking(x + 1)
                visited[x][y] = false
            }
        }
    }

    backTracking(0)
    println(cnt)
}
