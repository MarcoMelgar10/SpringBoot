package colorApplication;

import colorApplication.services.ColourPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class ColoursAplication implements CommandLineRunner {
    private ColourPrinter colourPrinter;
    public ColoursAplication(ColourPrinter colourPrinter){
        this.colourPrinter = colourPrinter;
        
    }

    public static void main(String[] args) {
        SpringApplication.run(ColoursAplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(colourPrinter.print());
    }
}