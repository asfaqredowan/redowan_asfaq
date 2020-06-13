package Day12_05172020;

import Reusable_Libraries.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Kayak_testNG_Assertion_testing {

    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();

    }//end of before

    @Test
    public void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com");
        Thread.sleep(2000);
        //verify the title using hard assertion
        //Assert.assertEquals(driver.getTitle(),"search Hotels, Cars");
        //using soft assertion
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(),"search Hotel, Cars");
        //click airport or city
        //Reusable_Library.click(driver,"//*[@data-placeholder='Enter an airport or city']","Search Field");
        Reusable_Library.click(driver,"//*[text()='Enter an airport or city']","Search fField");

        Thread.sleep(2000);

        //enter the airport
        Reusable_Library.userKeys(driver,"//*[@name='pickup']","JFK","Search Field");

        //click on the designated airport
        Reusable_Library.mouseClick(driver,"//*[@class='ap-code']","airport");

        Thread.sleep(2000);

        //click on date
        Reusable_Library.mouseClick(driver,"//*[@class='startDate _id7 _ijM _idA _ioF _ii0 _j0G _iQh']","date");
        //input date
        Thread.sleep(2000);
        Reusable_Library.userTypeAndHitEnter(driver,"//*[@id='vbGS-pickup-date-input']","06/19/2020","date");
        //Reusable_Library.mouseClick(driver,"//*[@id='vbGS-pickup-date-input']","date");
        //pass assertAll that way it doesn't skip aa your test steps
        sAssert.assertAll();



    }//end of test

    @AfterSuite
    public void closeSession(){
        //driver.quit();


    }//end


}
