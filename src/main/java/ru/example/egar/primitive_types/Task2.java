package ru.example.egar.primitive_types;

public class Task2 {
    //values for converter
    private final static int INT_BY_BYTE = 1000;
    private final static short SHORT_BY_BYTE = 12576;
    private final static char CHAR_BY_BYTE = 'Z';
    private final static float FLOAT_BY_LONG = 12576f;
    private final static long LONG_BY_INT = 12576L;
    private final static double DOUBLE_BY_LONG = 12576.0;

    //types for converter
    private static final String BYTE_VALUE_TYPES = "byte";
    private static final String INT_VALUE_TYPES = "int";
    private static final String LONG_VALUE_TYPES = "long";

    public static void main(String[] args) {
        convertAndPrintNumbers(INT_BY_BYTE, BYTE_VALUE_TYPES);
        convertAndPrintNumbers(SHORT_BY_BYTE, BYTE_VALUE_TYPES);
        convertAndPrintNumbers((int) CHAR_BY_BYTE, INT_VALUE_TYPES);
        convertAndPrintNumbers(FLOAT_BY_LONG, LONG_VALUE_TYPES);
        convertAndPrintNumbers(LONG_BY_INT, INT_VALUE_TYPES);
        convertAndPrintNumbers(DOUBLE_BY_LONG, INT_VALUE_TYPES);
    }

    private static void convertAndPrintNumbers(Number target, String type) {
        Number result = 0;
        switch (type.toLowerCase()) {
            case BYTE_VALUE_TYPES:
                result = target.byteValue();
                break;
            case INT_VALUE_TYPES:
                result = target.intValue();
                break;
            case LONG_VALUE_TYPES:
                result = target.longValue();
                break;
        }
        System.out.println(String.format("Convert %s %s to %s, result = %s",
                target, target.getClass().getSimpleName(), type, result));
    }
}
