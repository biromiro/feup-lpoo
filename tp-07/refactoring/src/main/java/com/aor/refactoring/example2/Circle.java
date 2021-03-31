package com.aor.refactoring.example2;

class Circle implements IShape{

    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return  2 * Math.PI * radius;
    }

    @Override
    public void draw(GraphicFramework graphics, double x, double y) {
        graphics.drawCircle(x, y, radius);
    }
}
