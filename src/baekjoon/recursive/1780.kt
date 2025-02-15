package baekjoon.recursive

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val paper = Array(n) { br.readLine().split(" ").map { it.toInt() } }

    var minusOne = 0
    var zero = 0
    var one = 0

    fun recursive(x: Int, y: Int, size: Int) {
        val target = paper[x][y]
        var isSame = true

        for (i in x until x + size) {
            for (j in y until y + size) {
                if (paper[i][j] != target) {
                    isSame = false
                    break
                }
            }
            if (!isSame) break
        }

        if (isSame) {
            when (target) {
                -1 -> minusOne++
                0 -> zero++
                1 -> one++
            }
        } else {
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    recursive(x + (size / 3) * i, y + (size / 3) * j, size / 3)
                }
            }
        }
    }

    recursive(0, 0, n)

    println(minusOne)
    println(zero)
    println(one)
}