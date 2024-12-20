package baekjoon.back_tracking

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var numbers = readln().split(" ").map { it.toInt() }.sorted()
    val hashMap = hashMapOf<Int, Int>()
    for (i in 0 until n) {
        hashMap[numbers[i]] = hashMap.getOrDefault(numbers[i], 0) + 1
    }

    numbers = numbers.distinct()

    val cntArr = IntArray(numbers.size)

    fun backTracking(
        depth: Int,
        str: String,
    ) {
        if (depth == m) {
            println(str.trim())
            return
        }

        for (i in numbers.indices) {
            if (cntArr[i] == hashMap[numbers[i]]) continue

            cntArr[i] = cntArr[i] + 1
            backTracking(depth + 1, "$str ${numbers[i]}")
            cntArr[i] = cntArr[i] - 1
        }
    }

    backTracking(0, "")
}
