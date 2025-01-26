package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val visited = Array(n) { BooleanArray(n) }

    val dx = arrayOf(0, -1, 1, 0, 0)
    val dy = arrayOf(0, 0, 0, -1, 1)

    var min = Int.MAX_VALUE

    fun canPlaceFlower(x: Int, y: Int): Boolean {
        repeat(5) {
            val nx = x + dx[it]
            val ny = y + dy[it]
            if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny]) {
                return false
            }
        }

        return true
    }

    fun placeFlower(x: Int, y: Int, place: Boolean): Int {
        var cost = 0
        repeat(5) {
            val nx = x + dx[it]
            val ny = y + dy[it]
            visited[nx][ny] = place
            cost += board[nx][ny]
        }
        return cost
    }

    fun backTracking(depth: Int, sum: Int) {
        if (depth == 3) {
            min = minOf(min, sum)
            return
        }

        for (x in 0 until n) {
            for (y in 0 until n) {
                if (canPlaceFlower(x, y)) {
                    val cost = placeFlower(x, y, true)
                    backTracking(depth + 1, sum + cost)
                    placeFlower(x, y, false)
                }
            }
        }
    }

    backTracking(0, 0)
    println(min)
}