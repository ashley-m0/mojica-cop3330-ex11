package oop.example;

import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 11 - Currency Conversion
At some point, you might have to deal with currency exchange rates, and you’ll need to ensure your
calculations are as precise as possible.

Write a program that converts currency. Specifically, convert euros to U.S. dollars. Prompt for the amount
of money in euros you have, and prompt for the current exchange rate of the euro. Print out the new amount
in U.S. dollars.

The formula for currency conversion is derived from:
c_to / c_frame = rate

where:
c_to is the amount in U.S. dollars.
c_from is the amount in euros.

rate is the per-unit current exchange rate from c_from to c_to.

Example Output:
How many euros are you exchanging? 81
What is the exchange rate? 1.3751
81 euros at an exchange rate of 1.3751 is
111.38 U.S. dollars.

Constraints:
Ensure that fractions of a cent are rounded up to the next penny.
Use a single output statement.

Challenges:
Build a dictionary of conversion rates and prompt for the countries instead of the rates.
Wire up your application to an external API that provides the current exchange rates.
 */

public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        String eurosString = myApp.getEuros();
        String rateString = myApp.getExchangeRate();

        double euros = myApp.convertStringToDouble(eurosString);
        double rate = myApp.convertStringToDouble(rateString);

        double dollars = myApp.calcEurosToDollars(euros, rate);

        String message = myApp.generateMessage(eurosString, rateString, dollars);
        System.out.println(message);

    }

    public String getEuros(){
        System.out.print("How many euros are you exchanging? ");
        String euros = input.nextLine();
        return euros;
    }

    public String getExchangeRate(){
        System.out.print("What is the exchange rate? ");
        String exchangeRate = input.nextLine();
        return exchangeRate;
    }

    public double convertStringToDouble(String word){
        return Double.parseDouble(word);
    }

    public double calcEurosToDollars(double euros, double rate){
        double dollars = euros * rate;
        double leftover = dollars % 0.01;

        if (leftover >= 0.005){
            dollars -= leftover;
            dollars += 0.01;
        }else{
            dollars -= leftover;
        }

        return dollars;
    }

    public String generateMessage(String euros, String rate, double dollars){
        return String.format("%s euros at an exchange rate of %s is\n%.2f U.S. dollars.", euros, rate, dollars);
    }
}
