package colorApplication.services.impl;

import colorApplication.services.BluePinter;
import colorApplication.services.ColourPrinter;
import colorApplication.services.GreenPinter;
import colorApplication.services.RedPinter;
import org.springframework.stereotype.Component;

@Component
public class ColourPrinterImpl implements ColourPrinter {
    private RedPinter redPinter;
    private BluePinter bluePinter;
    private GreenPinter greenPinter;



    public ColourPrinterImpl(RedPinter redPinter, BluePinter bluePinter, GreenPinter greenPinter){
    this.redPinter = redPinter;
    this.bluePinter = bluePinter;
    this.greenPinter = greenPinter;

    }

    @Override
    public String print() {
        return String.join(", ", redPinter.print(), bluePinter.print(), greenPinter.print());
    }
}
