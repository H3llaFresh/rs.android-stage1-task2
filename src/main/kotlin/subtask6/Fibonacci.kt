package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var smallerFibonacciNumber = 0
        var largerFibonacciNumber = 1
        val outputArray: IntArray = intArrayOf(0, 0 ,0)
        while(smallerFibonacciNumber * largerFibonacciNumber < n){
            val largerValue = largerFibonacciNumber
            largerFibonacciNumber += smallerFibonacciNumber
            smallerFibonacciNumber = largerValue
        }

        outputArray[0] = smallerFibonacciNumber
        outputArray[1] = largerFibonacciNumber

        if (smallerFibonacciNumber * largerFibonacciNumber == n) outputArray[2] = 1
        else outputArray[2] = 0

        return  outputArray
    }
}
