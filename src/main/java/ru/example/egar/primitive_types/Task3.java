package ru.example.egar.primitive_types;

public class Task3 {
    private static final int INT_VALUE = 100;
    private static final boolean BOOLEAN_VALUE = false;
    private static final char CHAR_VALUE = 'D';


    private static final Float FLOAT_VALUE = 100f; //Autoboxing
    private static final Long LONG_VALUE = 100L; //Autoboxing

    public static void main(String[] args) {
        //Unboxing
        System.out.println("Unboxing int for Integer, result class = " + ((Integer) INT_VALUE).getClass().getSimpleName());
        System.out.println("Unboxing boolean for Boolean, result class = " + ((Boolean) BOOLEAN_VALUE).getClass().getSimpleName());
        System.out.println("Unboxing char for Character, result class = " + ((Character) CHAR_VALUE).getClass().getSimpleName());
        //Autoboxing
        System.out.println("Autoboxing : " + (FLOAT_VALUE > 99f));
        System.out.println("Autoboxing : " + (LONG_VALUE < 100L));

    }
}
