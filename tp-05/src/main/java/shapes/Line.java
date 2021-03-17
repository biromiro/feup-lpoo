package shapes;

public class Line implements Shape{

    private double width;

    public Line(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
