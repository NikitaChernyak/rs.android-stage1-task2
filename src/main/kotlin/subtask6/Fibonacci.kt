package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {

        fun fib(x: Int): Int = if (x > 2) fib(x - 2) + fib(x - 1) else 1

        val result = mutableListOf<Int>()
        val fibNumbers = mutableListOf<Int>()
        var k = 1
        var nmbr: Int
        fibNumbers.add(0)
        do {
            nmbr = fib(k++)
            fibNumbers.add(nmbr)
        } while (nmbr < n)

        var product: Int
        for (i in 2 until fibNumbers.size) {
            product = fibNumbers[i - 1] * fibNumbers[i]
            if (product >= n) {
                result.add(fibNumbers[i - 1])
                result.add(fibNumbers[i])
                if (product == n) result.add(1) else result.add(0)
                break
            }
        }
        return result.toIntArray()
    }

}
