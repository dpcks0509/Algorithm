package baekjoon.implementation

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val alphabet = BooleanArray(26)

    for (i in 0 until n) {
        val words = br.readLine().split(" ")
        var isSpecified = false

        var one = ""
        for (word in words) {
            one += " "

            val index = word.first().lowercaseChar() - 'a'

            if (!isSpecified && !alphabet[index]) {
                one += "[${word[0]}]${word.slice(1..word.length - 1)}"
                alphabet[index] = true
                isSpecified = true
            } else {
                one += word
            }
        }

        if (isSpecified) {
            println(one.trimStart())
            continue
        }

        var two = ""
        for (word in words) {
            two += " "

            for (j in 0 until word.length) {
                val index = word[j].lowercaseChar() - 'a'

                if (!isSpecified && !alphabet[index]) {
                    two += "[${word[j]}]"
                    alphabet[index] = true
                    isSpecified = true
                } else {
                    two += word[j]
                }
            }
        }

        if (isSpecified) {
            println(two.trimStart())
        } else {
            println(words.joinToString(" "))
        }
    }
}
