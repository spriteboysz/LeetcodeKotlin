package algorithm

class P2413 {
    class Solution {
        fun smallestEvenMultiple(n: Int): Int {
            return if (n % 2 == 0) {
                n
            } else {
                n * 2
            }
        }
    }
}

fun main() {
    println("Hello world")
    val s = P2413.Solution()
    println(s.smallestEvenMultiple(100))
}