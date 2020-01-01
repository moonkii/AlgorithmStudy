package programmers

fun distinctEvenOrOdd(num: Int):String =
    when(num % 2) {
        0 -> "Even"
        else -> "Odd"
    }
