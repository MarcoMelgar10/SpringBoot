package SpringPractice._2.Car;

import SpringPractice._2.Car.Interface.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Ferrari implements Car {
    private int licensePlate;
    private String model;
    private Date age;

    @Override
    public void acelerar() {
        System.out.println("Ferrari is aceleranding");
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