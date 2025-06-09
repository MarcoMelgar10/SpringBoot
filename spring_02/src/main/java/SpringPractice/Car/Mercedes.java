package main.java.SpringPractice.Car;

import main.java.SpringPractice.Car.Interface.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class Mercedes implements Car {
    private int licensePlate;
    private String model;
    private Date age;

    @Override
    public void acelerar() {
        System.out.println("Mercedes have been acelerated...");;
    }

    @Override
    public void modelos(String modelo) {
        List<String> lista = new ArrayList<>();
        lista.add(modelo);
        if(!lista.isEmpty()){
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        }
    }


}
