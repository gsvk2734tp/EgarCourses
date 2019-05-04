package ru.example.egar.primitive_types;

import java.util.Arrays;

public class Task4 {
    //create 2 line
    private static String line1 = new String("line 1");
    private static StringBuilder line2 = new StringBuilder("line 2");

    public static void main(String[] args) {
        System.out.println("line 1 = " + line1);
        System.out.println("line 2 = " + line2);

        //reverse line2
        System.out.println("reverse line 2 " + line2.reverse());
        line2.reverse(); //convert back value

        //substring
        System.out.println("Substring line 1 = " + Arrays.toString(line1.split(" ")));
        System.out.println("Substring line 2 = " + Arrays.toString(line2.toString().split(" ")));

        //concat
        System.out.println("concat line 1 = " + line1.concat(line1));
        System.out.println("concat line 2 = " + line2.append(line2));
    }

}
