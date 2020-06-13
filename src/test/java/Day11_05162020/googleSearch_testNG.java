package Day11_05162020;

import Reusable_Libraries.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

public class googleSearch_testNG {
    //when using annotation method your local driver must be declared outside
    //so I can call it on my annotation method

    WebDriver driver;
    ArrayList<String> cars = new ArrayList();

    @Test
    public void googleSearch() throws InterruptedException {

        for (int i = 0; i <cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            //enter keyword cars on google search
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars.get(i), "search field");
            //click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK']", "google search button");
            //capture text
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "result");
            //Split the text and print
            String[] arraySearch = searchResult.split(" ");
            Reporter.log("My search number for car is " + arraySearch[1]);
            System.out.println("my search number for car is " + arraySearch[1]);

        }//end of loop
    }//end of google test


    @BeforeSuite
    public void callDriver() throws InterruptedException, IOException {
        cars.add("BMW");
        cars.add("Honda");

        driver = Reusable_Library.setDriver();

    }//end of BeforeMethod

    @AfterSuite
    public void quitDriver(){
        driver.quit();

    }//end of afterMethod





}//end of java class
