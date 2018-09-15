package com.example.phamf.calculator

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class ExampleUnitTest {

    @Test
    fun test_process_a_hard_math_case () {
        var case = "(30*2)/5 + 15^2*3 - 6*2^2 + ((8*8)^2) - 9^2/3 * (2^2*(3+2^2)*5)^2"
        var case2 = "20*3 - 30*2 - 3^2"
        assertEquals("-524441", processValueOf(case.removeAllSpace().processMinus()))
        assertEquals("-9", processValueOf(case2.removeAllSpace().processMinus()))
    }
}
