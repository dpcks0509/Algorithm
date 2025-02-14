package baekjoon.array

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    val x = br.readLine().toInt()

    var cnt = 0

    var left = 0
    var right = n - 1

    while (left < right) {
        if (numbers[left] + numbers[right] == x) {
            cnt++
            left++
            right--
        } else if (numbers[left] + numbers[right] < x) left++
        else right--
    }

    println(cnt)
}