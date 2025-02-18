package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val numbers = IntArray(n) { br.readLine().toInt() }

    val positive = numbers.filter { it > 1 }.sortedDescending()
    val negative = numbers.filter { it < 0 }.sorted()
    var sum = 0
    sum += numbers.count { it == 1 }

    for (i in 0 until positive.size step 2) {
        if (i + 1 < positive.size) sum += (positive[i] * positive[i + 1])
    }
    if (positive.size % 2 == 1) sum += positive[positive.size - 1]

    for (i in 0 until negative.size step 2) {
        if (i + 1 < negative.size) sum += (negative[i] * negative[i + 1])
    }
    if (negative.size % 2 == 1 && !numbers.contains(0)) {
        sum += negative[negative.size - 1]
    }

    println(sum)
}