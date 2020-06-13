package Day11_05162020;

import Reusable_Libraries.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class googleSearch_testNG_suites {
    //when using annotation method your local driver must be declared outside
    //so I can call it on my annotation method

    WebDriver driver;
    String getURL;

    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        //enter keyword cars on google search
        Reusable_Library.userKeys(driver, "//*[@name='q']", "Cars", "search field");
        //click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK']", "google search button");
        Thread.sleep(2000);
        //capture the current url for search result page
        getURL = driver.getCurrentUrl();
    }//end of priority 1

        //@Test(priority = 2)
        @Test(dependsOnMethods = "googleSearch")
        public void captureTheResult() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to(getURL);
        Thread.sleep(2000);
        //capture text
        String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']","result");
        //Split the text and print
        String[] arraySearch = searchResult.split(" ");
        System.out.println("my search number for car is " + arraySearch[1]);
    }//end of google test


    @BeforeSuite
    public void callDriver() throws InterruptedException, IOException {

        driver = Reusable_Library.setDriver();

    }//end of BeforeMethod

    @AfterSuite
    public void quitDriver(){

        driver.quit();

    }//end of afterMethod

}//end of java class
