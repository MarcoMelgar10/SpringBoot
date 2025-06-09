package colorApplication.services.impl;

import colorApplication.services.BluePinter;
import org.springframework.stereotype.Component;

public class EnglishBuePrinter implements BluePinter {
    @Override
    public String print() {
        return "Blue";
    }
}
