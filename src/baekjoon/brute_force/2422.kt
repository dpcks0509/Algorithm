package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val notAllowed = Array(n + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        notAllowed[a][b] = true
        notAllowed[b][a] = true
    }

    var count = 0

    for (i in 1..n) {
        for (j in (i + 1)..n) {
            if (notAllowed[i][j]) continue
            for (k in (j + 1)..n) {
                if (notAllowed[i][k] || notAllowed[j][k]) continue
                count++
            }
        }
    }

    println(count)
}
