package subtask4

import java.lang.StringBuilder

class Pangram {

    fun getResult(inputString: String): String {
        if (inputString.isBlank()) return ""

        val alphabet = "abcdefghijklmnopqrstuvwxyz"
        val vowels = "AaEeIiOoUuYy"
        val consonants = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZz"
        val sb = StringBuilder()
        val resultString = StringBuilder()
        val regex = """(\s)+""".toRegex()
        val inputStr = regex.replace(inputString.trim(), " ")
        val strings = inputStr.split(' ')
        var stringsWithInt = mutableListOf<Pair<String, Int>>()
        var pangram = true
        var letterCounter = 0

        for (i in alphabet)
            if (!inputString.toLowerCase().contains(i))
                pangram = false

        if (pangram) {

            for (i in strings) {
                for (j in i) {
                    if (vowels.contains(j)) {
                        letterCounter++
                    }
                }
                stringsWithInt.add(i to letterCounter)
                letterCounter = 0
            }

            stringsWithInt = stringsWithInt.sortedBy { (_, number) -> number }.toMutableList()

            for (i in stringsWithInt) {
                sb.append(i.second)
                for (j in i.first)
                    if (vowels.contains(j))
                        sb.append(j.toUpperCase())
                    else sb.append(j)

                resultString.append(sb)
                resultString.append(" ")
                sb.clear()
            }
            return resultString.trim().toString()

        } else {

            for (i in strings) {
                for (j in i) {
                    if (consonants.contains(j)) {
                        letterCounter++
                    }
                }
                stringsWithInt.add(i to letterCounter)
                letterCounter = 0
            }

            stringsWithInt = stringsWithInt.sortedBy { (_, number) -> number }.toMutableList()

            for (i in stringsWithInt) {
                sb.append(i.second)
                for (j in i.first)
                    if (consonants.contains(j))
                        sb.append(j.toUpperCase())
                    else sb.append(j)

                resultString.append(sb)
                resultString.append(" ")
                sb.clear()
            }
            return resultString.trim().toString()
        }

    }

}
