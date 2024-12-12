package baekjoon.implementation

class `17413` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val s = readLine()

            var tag = false
            val word = mutableListOf<Char>()
            s.forEach {
                when (it) {
                    '<' -> {
                        tag = true
                        word.reversed().forEach { ch ->
                            answer.append(ch)
                        }
                        word.clear()
                    }

                    '>' -> {
                        tag = false
                        answer.append('<')
                        word.forEach { ch ->
                            answer.append(ch)
                        }
                        answer.append('>')
                        word.clear()
                    }

                    ' ' -> {
                        if (tag) {
                            word += it
                        } else {
                            word.reversed().forEach {
                                answer.append(it)
                            }
                            answer.append(' ')
                            word.clear()
                        }
                    }

                    else -> {
                        word += it
                    }
                }
            }
            word.reversed().forEach {
                answer.append(it)
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
