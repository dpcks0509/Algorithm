package baekjoon.brute_force

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val numbers = BooleanArray(1000) { true }

    val n = br.readLine().toInt()

    repeat(n) {
        val (guess, strike, ball) = br.readLine().split(" ").map { it.toInt() }
        val guessStr = guess.toString()

        fun calculate(nStr: String): Pair<Int, Int> {
            var s = 0
            var b = 0

            for (i in 0..2) {
                if (guessStr[i] == nStr[i]) {
                    s++
                }

                if (guessStr.contains(nStr[i])) {
                    b++
                }
            }

            b -= s

            return Pair(s, b)
        }

        for (i in 100..999) {
            if (!numbers[i]) continue
            val nStr = i.toString()
            if (nStr.toSet().size != 3 || nStr.contains('0')) {
                numbers[i] = false
                continue
            }

            val (s, b) = calculate(nStr)

            if (!(s == strike && b == ball)) {
                numbers[i] = false
            }
        }
    }

    val answer = numbers.slice(100..999).count { it }
    bw.write(answer.toString())
    bw.flush()
    bw.close()
    br.close()
}