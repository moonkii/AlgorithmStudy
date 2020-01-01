package programmers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class EvenAndOddTest {
    @Test
    fun `짝수와 홀수 반환하기`(){
        assertThat(distinctEvenOrOdd(3)).isEqualTo("Odd")
        assertThat(distinctEvenOrOdd(4)).isEqualTo("Even")
    }
}
