package tony.greedy

class `1541` {
    fun solution(): String =
        with(System.`in`.bufferedReader()) {
            val answer = StringBuilder()

            val input = readLine()

            val numbers = ArrayDeque<Int>()
            val operators = ArrayDeque<Char>()

            var num = ""
            input.forEach {
                if (it == '+' || it == '-') {
                    operators.add(it)
                    numbers.add(num.toInt())
                    num = ""
                } else {
                    num += it
                }
            }
            numbers.add(num.toInt())

            while (operators.size >= 2) {
                val currentOp = operators.removeFirst()
                if (currentOp == '+') {
                    val firstNum = numbers.removeFirst()
                    val secondNum = numbers.removeFirst()
                    numbers.addFirst(firstNum + secondNum)
                } else {
                    val nextOp = operators.removeFirst()
                    if (nextOp == '+') {
                        val secondNum = numbers.removeAt(1)
                        val thirdNum = numbers.removeAt(1)
                        numbers.add(1, secondNum + thirdNum)
                        operators.addFirst(currentOp)
                    } else {
                        val firstNum = numbers.removeFirst()
                        val secondNum = numbers.removeFirst()
                        numbers.addFirst(firstNum - secondNum)
                        operators.addFirst(nextOp)
                    }
                }
            }

            if (operators.isNotEmpty()) {
                val op = operators.first()
                val n = if (op == '+') numbers[0] + numbers[1] else numbers[0] - numbers[1]
                answer.append(n)
            } else {
                answer.append(numbers.first())
            }

            close()
            return answer.toString()
        }
}

fun main(): Unit =
    with(System.out.bufferedWriter()) {
        write(`1541`().solution())

        flush()
        close()
    }
