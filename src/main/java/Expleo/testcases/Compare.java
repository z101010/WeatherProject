package Expleo.testcases;

import Expleo.pageobjects.AccuweatherPageObject;
import Expleo.pageobjects.Weather24PageObject;

import org.junit.Test;

public class Compare {

    @Test
    public void Main() throws Exception {
        AccuweatherPageObject AccuweatherPage = Accuweather.AccuWeatherData();
        Weather24PageObject w24Page = Weather24Test.Weather24Data();

        //Prints the min & max for both Accuweather & Weather24
        System.out.println("Accuweather: ");
        AccuweatherPage.printBoth();
        System.out.println("\n" + "Weather24: ");
        w24Page.printBoth();

   //I currently print the temperatures for both Accuweather & Weather24. If I had more time, I would have put it in a if statement to compare the temperatures and print the results.

    }


}
