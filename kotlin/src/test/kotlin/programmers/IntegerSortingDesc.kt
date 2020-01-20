package programmers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class IntegerSortingDesc {
    @Test
    fun `정수 내림차순으로 배치하기`() {
        assertThat(integerSortingDesc(118372)).isEqualTo(873211)
    }
}

fun integerSortingDesc(num: Long):Long =
    num.toString().toCharArray().sortedDescending().joinToString("").toLong()
