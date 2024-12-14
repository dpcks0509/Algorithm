package baekjoon.greedy

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().toInt() }

    var cnt = 0
    for (i in n - 1 downTo 1) {
        if (arr[i - 1] >= arr[i]) {
            val distance = arr[i - 1] - arr[i] + 1
            cnt += distance
            arr[i - 1] = arr[i - 1] - distance
        }
    }

    println(cnt)
}
