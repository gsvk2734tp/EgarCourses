package ru.example.egar.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("Circle1");
        Shape triangle = new Triangle();
        drawShape(circle);
        drawShape(triangle);
    }

    private static void drawShape(Shape shape) {
        shape.draw();
    }
}
