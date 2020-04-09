package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        val upper_a = a.toUpperCase()
        return if (upper_a.contains(b)) "YES"
        else {
            var i = 0
            var j = 0
            var counter = 0

            while (i < b.length && j < upper_a.length) {
                if (b[i] == upper_a[j]) {
                    i++
                    counter++
                }
                j++
            }
            if (counter < b.length) "NO"
            else "YES"
        }

    }

}
