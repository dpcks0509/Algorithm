package baekjoon.string

class `17413` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val str = readLine()
            val list = mutableListOf<Char>()
            str.forEach { ch ->
                if (ch == '<') {
                    if (list.isNotEmpty()) {
                        list.reversed().forEach { answer.append(it) }
                        list.clear()
                    }
                    list.add(ch)
                } else if (ch == '>') {
                    if (list.contains('<')) {
                        list.forEach { answer.append(it) }
                        list.clear()
                        answer.append(ch)
                    }
                } else if (ch == ' ') {
                    if (list.contains('<')) {
                        list.add(ch)
                    } else {
                        list.reversed().forEach { answer.append(it) }
                        list.clear()
                        answer.append(ch)
                    }
                } else {
                    list.add(ch)
                }
            }
            if (list.isNotEmpty()) {
                list.reversed().forEach { answer.append(it) }
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`17413`().solution())

        flush()
        close()
    }
