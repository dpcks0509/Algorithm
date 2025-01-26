package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val ingredients = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val used = BooleanArray(n)

    var min = Int.MAX_VALUE

    fun backTracking(s: Int, b: Int) {
        min = minOf(min, if (s >= b) s - b else b - s)

        for (i in 0 until n) {
            if (used[i]) continue

            used[i] = true
            backTracking(s * ingredients[i][0], b + ingredients[i][1])
            used[i] = false
        }
    }

    for (i in 0 until n) {
        used[i] = true
        backTracking(ingredients[i][0], ingredients[i][1])
        used[i] = false
    }

    println(min)
}