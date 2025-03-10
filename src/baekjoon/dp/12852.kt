package baekjoon.dp

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val count = IntArray(n + 1) { Int.MAX_VALUE }
    val before = IntArray(n + 1) { 0 }

    count[n] = 0

    val queue = ArrayDeque<Int>()
    queue.add(n)

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        if (cur % 3 == 0 && count[cur / 3] > count[cur] + 1) {
            count[cur / 3] = count[cur] + 1
            before[cur / 3] = cur
            queue.add(cur / 3)
        }

        if (cur % 2 == 0 && count[cur / 2] > count[cur] + 1) {
            count[cur / 2] = count[cur] + 1
            before[cur / 2] = cur
            queue.add(cur / 2)
        }

        if (cur - 1 >= 1 && count[cur - 1] > count[cur] + 1) {
            count[cur - 1] = count[cur] + 1
            before[cur - 1] = cur
            queue.add(cur - 1)
        }
    }

    println(count[1])

    var trace = 1
    val result = mutableListOf(1)
    while (trace != n) {
        trace = before[trace]
        result.add(trace)
    }

    println(result.reversed().joinToString(" "))
}
