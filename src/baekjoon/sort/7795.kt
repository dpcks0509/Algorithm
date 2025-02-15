package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()

    val T = br.readLine().toInt()
    repeat(T) {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        val A = br.readLine().split(" ").map { it.toInt() }
        val B = br.readLine().split(" ").map { it.toInt() }.sorted()

        var cnt = 0

        for (i in 0 until N) {
            var left = 0
            var right = M - 1

            while (left <= right) {
                val mid = (left + right) / 2

                if (A[i] > B[mid]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
            cnt += left
        }

        println(cnt)
    }
}