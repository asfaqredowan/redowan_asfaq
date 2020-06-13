package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_action {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //you declare and define web driver
        WebDriver driver = new ChromeDriver();

        //create a dynamic array for city to loop through certain values from the array

        String[] band = new String[5];
        band[0] = "Queen";
        band[1] = "Guns N Roses";
        band[2] = "AC/DC";
        band[3] = "Black Sabbath";
        band[4] = "Grateful Dead";

        //this is where u will start ur loop from navigate up until before quit
        for (int i = 0; i < band.length; i++) {

            //opening the browser automatically
            driver.navigate().to("http://www.bing.com");

            //maximize your browser
            driver.manage().window().maximize();

            //wait few seconds after navigating to page
            //sleep statements handle in milliseconds
            //1 second = 1000 millisecond
            Thread.sleep(2000);

            //locate the search field by inspection it first and then enter a keyword
            driver.findElement(By.id("sb_form_q")).sendKeys(band[i]);

            //click on google search
            //driver.findElement(By.name("btnK")).click();
            //if that method don't work use following
            driver.findElement(By.id("sb_form_q")).submit();

            //wait few seconds
            Thread.sleep(2000);

            //to capture text from website you need to
            String message = driver.findElement(By.id("sb_count")).getText();
            //using array variables to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("My city is " + band[i] + " and search number is " + arrayResult[1]);


        }//end of for loop
        //quit the session
        driver.quit();

        //close the session
        /*driver.close();*/


    }//end of main method
}//end of java class
