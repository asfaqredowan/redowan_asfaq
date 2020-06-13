package Day14_05312020;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WeightWatcher_Abstract extends Abstract_Class {


    @Test
            public void WeightWatchers() throws InterruptedException {
        logger.log(LogStatus.INFO,"WeightWatchers");

        //navigate to destination
        driver.navigate().to("https://www.weightwatchers.com");


        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10304");
        zipCode.add("10475");

        for (int i=0; i<=zipCode.size(); i++) {

        //store your actual title
        Reusable_Library_Logger.verifyTitle(driver,"Weight watchers: Weight loss & Wellness help",logger);
        Thread.sleep(2000);

        //locate find a workshop
        Reusable_Library_Logger.click(driver,"//*[@data-e2e-name='find_a workshop']","find workshop",logger);
        //Reusable_Library_Logger.click(driver,"//*[@id='ela-menu-visitor-desktop-supplementa_find-a-workshop']","find workshop",logger);
        Thread.sleep(2000);

         //enter zipcode
            Reusable_Library_Logger.userKeys(driver,"//*[@id='meetingSearch']",zipCode.get(i),"zipcode",logger);
         //driver.findElement(By.xpath("//*[@id='meetingSearch']")).sendKeys(zipcode[i]);
         //wait
        Thread.sleep(2000);
        Reusable_Library_Logger.click(driver,"//*[@class='btn spice-translated']","go",logger);
        //driver.findElement(By.xpath("//*[@class='btn spice-translated']")).submit();

        if (i==0){
            driver.findElements(By.xpath("//*[@class='location__name']")).get(0).click();
            Thread.sleep(2000);
        }if (i==1){
            driver.findElements(By.xpath("//*[@class='location__name']")).get(1).click();
                    Thread.sleep(2000);
        }if (i==2){
            driver.findElements(By.xpath("//*[@class='location__name']")).get(2).click();
                    Thread.sleep(2000);
        }//end of if

        String location = driver.findElement(By.xpath("//*[@class = 'location__name']")).getText();
        //driver.findElements(By.xpath("//div[contains(@class,'location__name')]")).get(2).click();

        System.out.println(location);

        //find schedule
        String schedule = driver.findElement(By.xpath("//*[@class='meeting-detail-bottom-top']")).getText();

        //print schedule
        System.out.println(schedule);





        }//end of if else method
    }//end of main method
}//end of java class