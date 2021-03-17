import area.AreaAggregator;
import area.AreaStringOutputter;
import area.AreaXMLOutputer;
import city.City;
import city.House;
import shapes.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator areaAggregator =  new AreaAggregator();

        areaAggregator.addAreaObject(new Circle(5));
        areaAggregator.addAreaObject(new Circle(2));
        areaAggregator.addAreaObject(new Square(3));
        areaAggregator.addAreaObject(new Elipse(4,5));
        areaAggregator.addAreaObject(new Rectangle(4,5));
        areaAggregator.addAreaObject(new Triangle(6,2));

        System.out.println((new AreaStringOutputter(areaAggregator)).output());
        System.out.println((new AreaXMLOutputer(areaAggregator)).output());

        List<House> houses = new ArrayList<>();
        houses.add(new House(14.33));
        houses.add(new House(15.99));

        City newCity = new City(houses);

        System.out.println((new AreaStringOutputter(newCity)).output());
        System.out.println((new AreaXMLOutputer(newCity)).output());

    }
}
