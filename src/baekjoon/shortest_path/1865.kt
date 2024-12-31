package baekjoon.shortest_path

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val tc = br.readLine().toInt()
    repeat(tc) {
        val (n, m, w) = br.readLine().split(" ").map { it.toInt() }

        // 플로이드 워셜 알고리즘
//        val times = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
//        for (i in 1..n) times[i][i] = 0
//
//        // 도로 (방향 x, 시간 +)
//        repeat(m) {
//            val (s, e, t) = br.readLine().split(" ").map { it.toInt() }
//            times[s][e] = minOf(times[s][e], t)
//            times[e][s] = minOf(times[e][s], t)
//        }
//
//        // 웜홀 (방향 o, 시간 -)
//        repeat(w) {
//            val (s, e, t) = br.readLine().split(" ").map { it.toInt() }
//            times[s][e] = minOf(times[s][e], -t)
//        }

//        for (k in 1..n) {
//            for (x in 1..n) {
//                for (y in 1..n) {
//                    if (times[x][k] != Int.MAX_VALUE && times[k][y] != Int.MAX_VALUE) {
//                        times[x][y] = minOf(times[x][y], times[x][k] + times[k][y])
//                    }
//                }
//            }
//        }

//        var isPossible = false
//        for (i in 1..n) {
//            if (times[i][i] < 0) {
//                isPossible = true
//                break
//            }
//        }

        // 벨만 포드 알고리즘
        data class Node(val location: Int, val time: Int)

        val board = Array(n + 1) { mutableListOf<Node>() }

        // 도로 (방향 x, 시간 +)
        repeat(m) {
            val (s, e, t) = br.readLine().split(" ").map { it.toInt() }
            board[s].add(Node(e, t))
            board[e].add(Node(s, t))
        }

        // 웜홀 (방향 o, 시간 -)
        repeat(w) {
            val (s, e, t) = br.readLine().split(" ").map { it.toInt() }
            board[s].add(Node(e, -t))
        }

        val times = IntArray(n + 1) { 100_000_000 }
        times[1] = 0

        // 벨만-포드 알고리즘으로 경로를 갱신
        repeat(n - 1) {
            for (i in 1..n) {
                for (node in board[i]) {
                    if (times[i] + node.time < times[node.location]) {
                        times[node.location] = times[i] + node.time
                    }
                }
            }
        }

        var isPossible = false

        // 음수 사이클 체크
        for (i in 1..n) {
            for (node in board[i]) {
                if (times[i] + node.time < times[node.location]) {
                    isPossible = true
                    break
                }
            }
            if (isPossible) break
        }

        sb.appendLine(if (isPossible) "YES" else "NO")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}