package colorApplication.configuration;

import colorApplication.services.BluePinter;
import colorApplication.services.ColourPrinter;
import colorApplication.services.GreenPinter;
import colorApplication.services.RedPinter;
import colorApplication.services.impl.ColourPrinterImpl;
import colorApplication.services.impl.SpanishBluePrinter;
import colorApplication.services.impl.SpanishGreenPrinter;
import colorApplication.services.impl.SpanishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfiguration {

    @Bean
    public BluePinter bluePinter(){
        return new SpanishBluePrinter();
    }
    @Bean
    public GreenPinter greenPinter(){
        return new SpanishGreenPrinter();
    }
    @Bean
    public RedPinter redPinter(){
        return new SpanishRedPrinter();
    }
    @Bean
    public ColourPrinter colourPrinter(BluePinter bluePinter, RedPinter redPinter, GreenPinter greenPinter) {
        return new ColourPrinterImpl(redPinter, bluePinter, greenPinter);
    }
}

