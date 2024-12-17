package baekjoon.math

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val (m, n, x, y) = readln().split(" ").map { it.toInt() }

        val lcm = lcm(m, n)

        fun solution(): Int {
            for (j in x..lcm step m) {
                if ((j - 1) % n + 1 == y) {
                    return j
                }
            }
            return -1
        }

        println(solution())
    }
}

fun gcd(
    a: Int,
    b: Int,
): Int = if (b != 0) gcd(b, a % b) else a

fun lcm(
    a: Int,
    b: Int,
): Int = a * b / gcd(a, b)
