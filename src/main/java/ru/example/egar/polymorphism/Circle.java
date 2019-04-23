package ru.example.egar.polymorphism;

import java.util.stream.IntStream;

public class Circle implements Shape {
    private String name;

    Circle(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("Draw " + name);
    }

    public void draw(int repeat) {
        IntStream.range(0, repeat)
                .forEach(x -> System.out.println(String.format("Step %d draw %s", x, name)));
    }

    @Override
    public void clear() {
        name = "";
    }
}
