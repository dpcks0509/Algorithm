package baekjoon.graph

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        val queue = ArrayDeque<Pair<Int, String>>()
        val visited = BooleanArray(10000) { false }

        queue.add(Pair(a, ""))
        visited[a] = true

        while (queue.isNotEmpty()) {
            val (num, commands) = queue.removeFirst()

            // 목적지에 도달한 경우
            if (num == b) {
                println(commands)
                break
            }

            // D 명령어
            val d = (2 * num) % 10000
            if (!visited[d]) {
                visited[d] = true
                queue.add(Pair(d, commands + "D"))
            }

            // S 명령어
            val s = if (num == 0) 9999 else num - 1
            if (!visited[s]) {
                visited[s] = true
                queue.add(Pair(s, commands + "S"))
            }

            // L 명령어
            val l = (num % 1000) * 10 + (num / 1000)
            if (!visited[l]) {
                visited[l] = true
                queue.add(Pair(l, commands + "L"))
            }

            // R 명령어
            val r = (num % 10) * 1000 + (num / 10)
            if (!visited[r]) {
                visited[r] = true
                queue.add(Pair(r, commands + "R"))
            }
        }
    }
}
