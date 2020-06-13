package day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_mortgage_calculator {
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
        driver.navigate().to("https://www.mortgagecalculator.org");

        //wait
        Thread.sleep(2000);

        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll all the way to the bottom of the page
        //jse.executeScript("scroll(0,5000)");
        //wait
        //Thread.sleep(2000);
        //scroll all the way to the top of the page
        //jse.executeScript("scroll(0,-5000)");

        //scrolling to an element view
        try {
            WebElement iRate = driver.findElement(By.xpath("//*[@id='intrstsrate']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",iRate);
        }catch (Exception e){
            System.out.println("unable to locate interest rate" + e);
        }


    }//end of main method
}//end of java class
