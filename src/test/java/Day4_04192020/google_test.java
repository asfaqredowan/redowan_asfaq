package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_test {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //you declare and define web driver
        WebDriver driver = new ChromeDriver();

        //opening the browser automatically
        driver.navigate().to("http://www.google.com");

        //maximize your browser
        driver.manage().window().maximize();

        //wait few seconds after navigating to page
        //sleep statements handle in milliseconds
        //1 second = 1000 millisecond
        Thread.sleep(2000);

        //locate the search field by inspection it first and then enter a keyword
        driver.findElement(By.name("q")).sendKeys("cars");

        //click on google search
        driver.findElement(By.name("btnK")).click();
        //if that method don't work use following
        //driver.findElement(By.name("btnK")).submit();

        //wait few seconds
        Thread.sleep(2000);

        //to capture text from website you need to
        String message = driver.findElement(By.id("result-stats")).getText();
        //using array variables to split above message
        String[] arrayResult = message.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //quit the session
        driver.quit();

        //close the session
        /*driver.close();*/


    }//end of main method
}//end of java class
