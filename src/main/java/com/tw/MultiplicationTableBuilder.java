package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiplicationTableBuilder {

    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 1000;

    public static void main(String[] args) {
        MultiplicationTableBuilder builder = new MultiplicationTableBuilder();
        int start = 2;
        int end = 4;
        String multiplicationTable = builder.generateMultiplicationTable(start, end);

        System.out.println(multiplicationTable);
    }

    public static String generateMultiplicationTable(int startNumber, int endNumber) {
        if (!isValid(startNumber, endNumber)) {
            return null;
        }
        return buildMultiplicationTable(startNumber, endNumber);
    }


    public static boolean isValidInputOnRange(int number) {
        return number > MIN_NUMBER && number <= MAX_NUMBER;
    }

    public static boolean isStartValueSmallerEndValue(int startNumber, int endNumber) {
        return startNumber <= endNumber;
    }

    public static boolean isValid(int startNumber, int endNumber) {
        return isValidInputOnRange(startNumber) && isValidInputOnRange(endNumber) && isStartValueSmallerEndValue(startNumber, endNumber);
    }

    public static String buildMultiplicationRow(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .mapToObj(i -> i + "*" + endNumber + "=" + i * endNumber)
                .collect(Collectors.joining(" "));
    }

    public static String buildMultiplicationTable(int startNumber, int endNumber) {

        return IntStream.rangeClosed(startNumber, endNumber)
                .mapToObj(i -> buildMultiplicationRow(startNumber, i))
                .collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator();
    }
}
