package baekjoon.string

fun main() {
    val br = System.`in`.bufferedReader()

    val str = br.readLine()

    var cnt = 0

    var index = 0
    while (index < str.length) {
        when (str[index]) {
            'c' -> {
                if (index + 1 < str.length && (str[index + 1] == '=' || str[index + 1] == '-')) {
                    cnt++
                    index += 2
                } else {
                    cnt++
                    index++
                }
            }

            'd' -> {
                if (index + 2 < str.length && (str[index + 1] == 'z' && str[index + 2] == '=')) {
                    cnt++
                    index += 3
                } else if (index + 1 < str.length && str[index + 1] == '-') {
                    cnt++
                    index += 2
                } else {
                    cnt++
                    index++
                }
            }

            'l', 'n' -> {
                if (index + 1 < str.length && str[index + 1] == 'j') {
                    cnt++
                    index += 2
                } else {
                    cnt++
                    index++
                }
            }

            's', 'z' -> {
                if (index + 1 < str.length && str[index + 1] == '=') {
                    cnt++
                    index += 2
                } else {
                    cnt++
                    index++
                }
            }

            else -> {
                cnt++
                index++
            }
        }
    }

    println(cnt)
}