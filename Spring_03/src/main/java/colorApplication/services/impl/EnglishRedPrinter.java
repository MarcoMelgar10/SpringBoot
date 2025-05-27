package colorApplication.services.impl;

import colorApplication.services.RedPinter;
import org.springframework.stereotype.Component;


public class EnglishRedPrinter implements RedPinter {
    @Override
    public String print() {
        return "Red";
    }
}
