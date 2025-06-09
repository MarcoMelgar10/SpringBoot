package main.java.SpringPractice.Configuration;

import main.java.SpringPractice.Car.Ferrari;
import main.java.SpringPractice.Car.Interface.Car;
import main.java.SpringPractice.Car.Mazda;
import main.java.SpringPractice.Car.Mercedes;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class Configuration {
    @PostConstruct
    public void initCars(){
        ArrayList<Car> cars = new ArrayList<>();
        Ferrari ferrari = new Ferrari(1, "gt", new Date());
        Mazda mazda  = new Mazda(10, "cx", new Date());
        Mercedes mercedes = new Mercedes(20, "Gla", new Date());
        cars.add(ferrari);
        cars.add(mazda);
        cars.add(mercedes);
        for (int i = 0; i < 5; i++) {
            ferrari.modelos("Gt" + i);
            mercedes.modelos("Gla" + i);
            mazda.modelos("Cx" + i);
        }
        for(Car car: cars){
            car.acelerar();
        }
    }

}
