package baekjoon.string

class `17609` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val n = readLine().toInt()
            repeat(n) {
                val str = readLine()
                val result =
                    when {
                        isPalindrome(str, 0, str.length - 1) -> 0
                        isPseudoPalindrome(str) -> 1
                        else -> 2
                    }
                answer.append("$result\n")
            }

            close()
            return answer.toString()
        }

    private fun isPalindrome(
        str: String,
        left: Int,
        right: Int,
    ): Boolean {
        var l = left
        var r = right
        while (l <= r) {
            if (str[l] != str[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }

    private fun isPseudoPalindrome(str: String): Boolean {
        var left = 0
        var right = str.length - 1

        while (left <= right) {
            if (str[left] != str[right]) {
                return isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1)
            }
            left++
            right--
        }
        return true
    }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`17609`().solution())

        flush()
        close()
    }
