package com.tw;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTableBuilder {

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
        return number > 1 && number <= 1000;
    }

    public static boolean isStartValueSmallerEndValue(int startNumber, int endNumber) {
        return startNumber <= endNumber;
    }

    public static boolean isValid(int startNumber, int endNumber) {
        return isValidInputOnRange(startNumber) && isValidInputOnRange(endNumber) && isStartValueSmallerEndValue(startNumber, endNumber);
    }

    public static String buildMultiplicationRow(int startNumber, int endNumber) {
        StringBuilder builder = new StringBuilder();
        for (int i = startNumber; i <= endNumber; i++) {
            builder.append(i).append("*").append(endNumber).append("=").append(i * endNumber);
            if (i != endNumber) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static String buildMultiplicationTable(int startNumber, int endNumber) {
        List<String> rows = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            rows.add(buildMultiplicationRow(startNumber, i));
        }
        StringBuilder builder = new StringBuilder();
        for (String row : rows) {
            builder.append(row).append("\r\n");
        }
        return builder.toString();
    }
}
