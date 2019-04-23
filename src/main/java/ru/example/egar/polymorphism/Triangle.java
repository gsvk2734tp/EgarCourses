package ru.example.egar.polymorphism;

import java.util.stream.IntStream;

public class Triangle implements Shape {
    private String name = "Triangle";
    private Integer size = 100;

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void draw() {
        System.out.println(String.format("Draw %s where size = %d", name, size));
    }

    public void draw(int repeat) {
        IntStream.range(0, repeat)
                .forEach(x -> System.out.println(String.format("Step %d draw name %s and size %d", x, name, size)));
    }

    @Override
    public void clear() {
        name = "";
        size = 0;
    }
}
