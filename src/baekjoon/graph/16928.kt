package baekjoon.graph

fun main() {
    data class Move(
        val location: Int,
        val count: Int,
    )

    val (n, m) = readln().split(" ").map { it.toInt() }

    val board = IntArray(101) { -1 }
    repeat(n + m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        board[x] = y
    }

    val queue = ArrayDeque<Move>()
    queue.add(Move(1, 0))
    board[1] = 0

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        for (i in 1..6) {
            val next = current.location + i
            if (next == 100) {
                println(current.count + 1)
                return
            }

            val nextLocation = board[next]
            if (nextLocation == 0) continue

            if (nextLocation == -1) {
                queue.add(Move(next, current.count + 1))
                board[next] = 0
            } else {
                queue.add(Move(nextLocation, current.count + 1))
                board[nextLocation] = 0
            }
        }
    }
}
