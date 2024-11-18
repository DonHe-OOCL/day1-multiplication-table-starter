package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTableBuilderTest {
    @Test
    void should_return_multiply_table_when_build_given_start_number_2_end_number_4() {
        //given
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 2;
        int end = 4;
        //when
        String multiplicationTable = builder.build(start, end);
        String expectedMultiplicationTable = String.format("2*2=4%n2*3=6 3*3=9%n2*4=8 3*4=12 4*4=16%n");
        //then
        assertEquals(expectedMultiplicationTable, multiplicationTable);
    }

    @Test
    void should_return_null_when_build_given_start_number_2_end_number_1() {
        //given
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 2;
        int end = 1;
        //when
        String multiplicationTable = builder.build(start, end);
        //then
        assertNull(multiplicationTable);
    }

    @Test
    void should_return_null_when_build_given_start_number_0_end_number_2() {
        //given
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 0;
        int end = 2;
        //when
        String multiplicationTable = builder.build(start, end);
        //then
        assertNull(multiplicationTable);
    }

    @Test
    void should_return_null_when_build_given_start_number_2_end_number_1001() {
        //given
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 2;
        int end = 1001;
        //when
        String multiplicationTable = builder.build(start, end);
        //then
        assertNull(multiplicationTable);
    }

    @Test
    void should_return_true_when_isValidInputOnRange_given_number_2() {
        //given
        int number = 2;
        //when
        boolean isValid = MultiplicationTableBuilder.isValidInputOnRange(number);
        //then
        assertTrue(isValid);
    }

    @Test
    void should_return_true_when_isValidInputOnRange_given_number_10001() {
        //given
        int number = 10001;
        //when
        boolean isValid = MultiplicationTableBuilder.isValidInputOnRange(number);
        //then
        assertFalse(isValid);
    }

    @Test
    void should_return_true_when_isStartValueSmallerEndValue_given_number_2_and_4() {
        //given
        int startNumber = 2;
        int endNumber = 4;
        //when
        boolean isStartValueSmallerEndValue = MultiplicationTableBuilder.isStartValueSmallerEndValue(startNumber, endNumber);
        //then
        assertTrue(isStartValueSmallerEndValue);
    }

    @Test
    void should_return_false_when_isStartValueSmallerEndValue_given_number_6_and_4() {
        //given
        int startNumber = 6;
        int endNumber = 4;
        //when
        boolean isStartValueSmallerEndValue = MultiplicationTableBuilder.isStartValueSmallerEndValue(startNumber, endNumber);
        //then
        assertFalse(isStartValueSmallerEndValue);
    }
}
