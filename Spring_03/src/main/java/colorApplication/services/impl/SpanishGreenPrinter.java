package colorApplication.services.impl;

import colorApplication.services.GreenPinter;
import org.springframework.stereotype.Component;


public class SpanishGreenPrinter implements GreenPinter {
    @Override
    public String print() {
        return "Verde";
    }
}
