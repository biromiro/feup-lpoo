package city;

import area.SumProvider;

import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider {

    List<House> houseList;

    public City(List<House> houses){
        this.houseList = houses;
    }

    @Override
    public double sum() {
        double sum = 0.0;
        for(House house: houseList){
            sum += house.getArea();
        }
        return sum;
    }
}
