package baekjoon.two_pointer

fun main() {
    val n = readln().toInt()
    val fruits = readln().split(" ").map { it.toInt() }.toMutableList()

    val hashMap = hashMapOf<Int, Int>()
    var max = 0
    var left = 0

    for (right in 0 until n) {
        hashMap[fruits[right]] = hashMap.getOrDefault(fruits[right], 0) + 1

        while (hashMap.size > 2) {
            hashMap[fruits[left]] = hashMap[fruits[left]]!! - 1

            if (hashMap[fruits[left]] == 0) {
                hashMap.remove(fruits[left])
            }
            left++
        }

        max = maxOf(max, right - left + 1)
    }

    println(max)
}
