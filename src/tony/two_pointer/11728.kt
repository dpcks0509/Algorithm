package tony.two_pointer

class `11728` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = mutableListOf<Int>()

            val (n, m) = readLine().split(" ").map { it.toInt() }

            val a = readLine().split(" ").map { it.toInt() }
            val b = readLine().split(" ").map { it.toInt() }

            var left_a = 0
            var left_b = 0
            while (left_a < n && left_b < m) {
                if (a[left_a] < b[left_b]) {
                    answer.add(a[left_a])
                    left_a++
                } else {
                    answer.add(b[left_b])
                    left_b++
                }
            }
            if (left_a == n) {
                for (i in left_b until m) {
                    answer.add(b[i])
                }
            }
            if (left_b == m) {
                for (i in left_a until n) {
                    answer.add(a[i])
                }
            }

            close()
            return answer.joinToString(" ")
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11728`().solution())

        flush()
        close()
    }
