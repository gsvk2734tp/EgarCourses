package ru.example.egar.exceptions;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AllException {
    public static void main(String[] args) {
        try {
            printArithmeticException();
        } catch (ArithmeticException e1) {
            System.out.println(e1); // Вместо printStackTrace для удобства чтения
        }

        try {
            printArrayIndexOutOfBoundException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println(e2);
        }

        try {
            printClassNotFoundException();
        } catch (ClassNotFoundException e3) {
            System.out.println(e3);
        }

        try {
            printFileNotFoundException();
        } catch (FileNotFoundException e4) {
            System.out.println(e4);
        }

        try {
            printIOException();
        } catch (IOException e5) {
            System.out.println(e5);
        }

        try {
            printNoSuchFieldException();
        } catch (NoSuchFieldException e6) {
            System.out.println(e6);
        }

        try {
            printNoSuchMethodException();
        } catch (NoSuchMethodException e7) {
            System.out.println(e7);
        }

        try {
            printNullPointerException();
        } catch (NullPointerException e8) {
            System.out.println(e8);
        }

        try {
            printNumberFormatException();
        } catch (NumberFormatException e9) {
            System.out.println(e9);
        }

        try {
            printRuntimeException();
        } catch (RuntimeException e10) {
            System.out.println(e10);
        }

        try {
            printStringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e11) {
            System.out.println(e11);
        }

    }

    private static void printArithmeticException() throws ArithmeticException {
        System.out.println(1 / 0);
    }

    private static void printArrayIndexOutOfBoundException() throws ArrayIndexOutOfBoundsException {
        int i[] = new int[1];
        System.out.println(i[2]);
    }

    private static void printClassNotFoundException() throws ClassNotFoundException {
        Class.forName("WebDriver");
    }

    private static void printFileNotFoundException() throws FileNotFoundException {
        BufferedReader readFile = new BufferedReader(new FileReader(new File("C:\\secretFile.txt")));
    }

    private static void printIOException() throws IOException {
        throw new IOException();
    }

    private static void printNoSuchFieldException() throws NoSuchFieldException {
        Field field = AllException.class.getDeclaredField("String");
    }

    private static void printNoSuchMethodException() throws NoSuchMethodException {
        Method method = AllException.class.getMethod("printString()");
    }

    private static void printNullPointerException() throws NullPointerException {
        String line = null;
        System.out.println(line.trim());
    }

    private static void printNumberFormatException() throws NumberFormatException {
        Integer count = Integer.parseInt("100C");
    }

    private static void printRuntimeException() throws RuntimeException {
        throw new RuntimeException();
    }

    private static void printStringIndexOutOfBoundsException() throws StringIndexOutOfBoundsException{
        String line = new String("line");
        System.out.println(line.substring(5));
    }
}
