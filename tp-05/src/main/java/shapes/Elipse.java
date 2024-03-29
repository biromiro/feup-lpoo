package shapes;

public class Elipse implements AreaShape{

    double x_radius, y_radius;

    public Elipse(double x_radius, double y_radius){
        this.x_radius = x_radius;
        this.y_radius = y_radius;
    }

    public double getX_radius() {
        return x_radius;
    }

    public double getY_radius() {
        return y_radius;
    }

    @Override
    public double getArea() {
        return Math.PI * x_radius * y_radius;
    }

    @Override
    public void draw() {
        System.out.println("Elipse");
    }
}
