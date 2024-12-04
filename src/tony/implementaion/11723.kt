package tony.implementaion

class `11723` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val m = readLine().toInt()

            val set = mutableSetOf<Int>()
            repeat(m) {
                val input = readLine().split(' ')
                when (input[0]) {
                    "add" -> {
                        val x = input[1].toInt()
                        set.add(x)
                    }

                    "remove" -> {
                        val x = input[1].toInt()
                        set.remove(x)
                    }

                    "check" -> {
                        val x = input[1].toInt()
                        val check = if (set.contains(x)) "1" else "0"
                        answer.appendLine(check)
                    }

                    "toggle" -> {
                        val x = input[1].toInt()
                        if (set.contains(x)) set.remove(x) else set.add(x)
                    }

                    "all" -> {
                        for (i in 1..20) {
                            set.add(i)
                        }
                    }

                    "empty" -> {
                        set.clear()
                    }
                }
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`11723`().solution())

        flush()
        close()
    }
