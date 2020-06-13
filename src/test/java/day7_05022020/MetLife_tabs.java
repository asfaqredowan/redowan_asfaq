package day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class MetLife_tabs {
    public static void main(String[] args) throws InterruptedException {
        //set chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some condition
        ChromeOptions options = new ChromeOptions();
        //add some arguments on chrome driver
        options.addArguments("start-maximized", "incognito");
        //define chrome driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to destination
        driver.navigate().to("https://www.metlife.com");

        //driver.getTitle();
        //System.out.println(driver.getTitle());

        //wait
        Thread.sleep(2000);

        try {
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
        } catch (Exception e) {
            System.out.println("unable to click on SOLUTIONS" + e);
        }//end of SOLUTION exception

        //wait
        Thread.sleep(2000);

        try {
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        } catch (Exception e) {
            System.out.println("unable to click on MetLife TakeAlong Dental" + e);
        }//end of MetLife TakeAlong Dental exception

        //wait
        Thread.sleep(2000);

        try {
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        } catch (Exception e) {
            System.out.println("unable to click on Enroll Now" + e);
        }//end of Enroll Now exception

        //define the ArrayList to all current tabs that are open
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second window
        driver.switchTo().window(tabs.get(1));

        //wait
        Thread.sleep(2000);

        //enter zipcode
        try {
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");
        } catch (Exception e) {
            System.out.println("unable to enter on search field" + e);
        }//end of Zipcode exception

        //wait
        Thread.sleep(1500);

        //close the tab
        driver.close();

        //switch to second window
        driver.switchTo().window(tabs.get(0));

        //if there is another new tab then we have to redefine it
        //tabs = new ArrayList<>(driver.getWindowHandles());


    }//end of main method
}//end of java class
