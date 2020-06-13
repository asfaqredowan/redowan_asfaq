package Day14_05312020;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_htmlReport_Abstract extends Abstract_Class {

    @Test
    public void yahoo_verification() throws InterruptedException {

        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"navigate to yahoo homepage");
        driver.navigate().to("https://www.yahoo.com");
        //3 seconds to load page
        Thread.sleep(4000);
        //i want to count all the links in yahoo homepage and print it
        logger.log(LogStatus.INFO,"homepage count");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if link count returns you 12 links
        if (linkCount.size()==12){
            System.out.println("my yahoo page count is" + linkCount.size());
            logger.log(LogStatus.PASS,"my yahoo homepage count matches and it is " + linkCount.size());
        }else{
            System.out.println("my yahoo page count doesn't match" + linkCount);
            logger.log(LogStatus.FAIL,"my yahoo homepage count doesn't match " + linkCount);
        }//end of if method
        //click on sign in
        Reusable_Library_Logger.click(driver,"//*[@id='header-signin-link']","Sign In",logger);
        Thread.sleep(3000);
        //verify ethe state of the checkbox is checked for stay signed in
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == false){
            System.out.println("checkbox isn't selected by default");
            logger.log(LogStatus.FAIL,"checkbox isn't selected by default");
        }else {
            System.out.println("checkbox is selected by default");
            logger.log(LogStatus.PASS,"checkbox is selected by default");
        }//end of else

    }//end of test method


}//end of java class
