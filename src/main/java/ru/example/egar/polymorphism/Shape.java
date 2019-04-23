package ru.example.egar.polymorphism;

public interface Shape {
    void draw();

    default void clear() {
        System.out.println("");
    }
}
