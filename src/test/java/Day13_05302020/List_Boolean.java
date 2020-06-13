package Day13_05302020;

import Reusable_Libraries.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;

public class List_Boolean {

    //declare web driver
    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
    }//end of before method

    @Test
    public void yahoo_verification() throws InterruptedException {
        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //3 seconds to load page
        Thread.sleep(4000);
        //i want to count all the links in yahoo homepage and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if link count returns you 12 links
        if (linkCount.size()==12){
            System.out.println("my yahoo page count is" + linkCount.size());
        }else{
            System.out.println("my yahoo page count doesnt match" + linkCount);
        }//end of if method
        //click on sign in
        Reusable_Library.click(driver,"//*[@id='header-signin-link']","Sign In");
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState==true){
            System.out.println("checkbox is selected by default");
        }else {
            System.out.println("checkbox isn't selected by default");
        }//end of else
    }//end of test method

    @AfterSuite
    public void quitDriver(){
        //driver.quit();
    }//end of after suit

}//end of java class
