package baekjoon.sort

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val array = Array(n) { br.readLine().toLong() }

    val hashMap = hashMapOf<Long, Int>()
    for (i in 0 until n) {
        hashMap[array[i]] = hashMap.getOrDefault(array[i], 0) + 1
    }

    val max = hashMap.maxOf { it.value }
    val answer = hashMap.filter { it.value == max }.keys.minOrNull()

    println(answer)
}