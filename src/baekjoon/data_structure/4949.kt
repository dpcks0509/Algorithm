package baekjoon.data_structure

class `4949` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            while (true) {
                val str = readLine().toCharArray()
                if (str.size == 1 && str[0] == '.') break

                val deque = ArrayDeque<Char>()
                var balance = "yes"
                str.forEach {
                    when (it) {
                        '(', '[' -> deque.add(it)
                        ')' -> {
                            if (deque.isEmpty() || deque.removeLast() != '(') {
                                balance = "no"
                                return@forEach
                            }
                        }

                        ']' -> {
                            if (deque.isEmpty() || deque.removeLast() != '[') {
                                balance = "no"
                                return@forEach
                            }
                        }
                    }
                }
                if(deque.isNotEmpty()) balance = "no"
                answer.appendLine(balance)
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`4949`().solution())

        flush()
        close()
    }
