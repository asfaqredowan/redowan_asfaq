package day6_04262020;

import Reusable_Libraries.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Action_item3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        /*//set chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some condition
        ChromeOptions options = new ChromeOptions();
        //add some arguments on chrome driver
        options.addArguments("start-maximized", "incognito");*/
        //define chrome driver
        WebDriver driver = Reusable_Library.setDriver();
        //navigate to destination
        driver.navigate().to("https://www.weightwatchers.com");

        //wait time
        //Thread.sleep(2000);

        String[] zipcode = new String[3];
        zipcode[0] = "11218";
        zipcode[1] = "10304";
        zipcode[2] = "10475";

        //store your actual title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Weight watchers: Weight loss & Wellness help")){
            System.out.println("Title matches with expected");
        }else {
            System.out.println("Title doesn't match " + actualTitle);
            for (int i=0; i<=2; i++) {
                //locate find a workshop
                driver.findElement(By.xpath("//*[@id='ela-menu-visitor-desktop-supplementa_find-a-workshop']")).click();
         //wait
         Thread.sleep(2000);
         //input zipcode
         driver.findElement(By.xpath("//*[@id='meetingSearch']")).sendKeys(zipcode[i]);
         //wait
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='btn spice-translated']")).submit();

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




            }//end of for
        }//end of if else method
    }//end of main method
}//end of java class