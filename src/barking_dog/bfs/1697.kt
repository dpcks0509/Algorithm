package barking_dog.bfs

class `1697` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val (n, k) = readLine().split(' ').map { it.toInt() }
            val dist = IntArray(100001) { -1 }
            val queue = ArrayDeque<Int>()

            dist[n] = 0
            queue.addLast(n)

            fun move(
                cur: Int,
                next: Int,
            ) {
                if (next < 0 || next > 100000) return
                if (dist[next] != -1) return
                dist[next] = dist[cur] + 1
                queue.addLast(next)
            }

            while (dist[k] == -1) {
                val cur = queue.removeFirst()
                move(cur, cur - 1)
                move(cur, cur + 1)
                move(cur, cur * 2)
            }

            answer.append("${dist[k]}")

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1697`().solution())

        flush()
        close()
    }
