package com.aor.refactoring.example2;

public class Shape {

    private final double x;
    private final double y;
    private final IShape currentShape;

    public Shape(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.currentShape = new Rectangle(width, height);
    }

    public Shape(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.currentShape = new Circle(radius);
    }

    public double getArea() {
        return currentShape.getArea();
    }

    public double getPerimeter() {
        return currentShape.getPerimeter();
    }

    public void draw(GraphicFramework graphics) {
        currentShape.draw(graphics, x, y);
    }
}
