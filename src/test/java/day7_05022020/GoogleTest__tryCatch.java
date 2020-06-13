package day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class GoogleTest__tryCatch {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //you declare and define web driver
        WebDriver driver = new ChromeDriver();

        //set array list for the cars
        ArrayList<String> cars = new ArrayList<>();
        cars.add("lexus");
        cars.add("Ford");
        cars.add("Honda");
        cars.add("BMW");
        cars.add("Tesla");

        for (int i = 0; i < cars.size(); i++) {

            //opening the browser automatically
            driver.navigate().to("http://www.google.com");
            //maximize your browser
            driver.manage().window().maximize();

            //wait
            Thread.sleep(2000);

            //using ty catch exception to handle any error

            try {
                //locate the search field by inspecting it then enter keyword cars
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("unable to enter the data on search field" + e);
            }//end of search field exception

            try {
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            } catch (Exception e) {
                System.out.println("unable to submit on search icon" + e);
            }//end of search icon exception

            //wait
            Thread.sleep(2000);

            try {
                //to capture text from website you need to
                String message = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                //using array variables to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("unable to capture on search Result " + e);
            }//end of search result exception


            //quit the session
            //driver.quit();

            //close the session
            /*driver.close();*/

        }//end of for loop
    }//end of main method
}//end of java class
