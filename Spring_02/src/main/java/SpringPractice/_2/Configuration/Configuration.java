package SpringPractice._2.Configuration;

import SpringPractice._2.Car.Ferrari;
import SpringPractice._2.Car.Interface.Car;
import SpringPractice._2.Car.Mazda;
import SpringPractice._2.Car.Mercedes;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
