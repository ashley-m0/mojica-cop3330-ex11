package oop.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    @Test
    public void includes_correct_calculations(){
        App myApp = new App();
        String eurosString = "81";
        String rateString = "1.3751";

        double euros = myApp.convertStringToDouble(eurosString);
        double rate = myApp.convertStringToDouble(rateString);

        double dollars = myApp.calcEurosToDollars(euros, rate);

        String actualMessage = myApp.generateMessage(eurosString, rateString, dollars);
        String expectedMessage = "81 euros at an exchange rate of 1.3751 is\n" +
                "111.38 U.S. dollars.";

        assertEquals(expectedMessage, actualMessage);
    }
}
