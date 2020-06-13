package day5_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locate_by_Xpath {
    public static void main(String[] args) throws InterruptedException {
        //line below store your search field xpath as a string variable
        String searchPath = "//*[@name='field-keyword']";
        //line below store your search icon xpath as a string variable
        String searchIconPath = "//*[@value='Go']";
        //line below store your image icon xpath as a string variable
        String imagePath = "//img[contains(@class, s-image')]";

        //set the system chrome driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to("https://www.amazon.com");
        //maximize window
        driver.manage().window().maximize();
        //wait few seconds
        //Thread.sleep(2000);

        //enter a keyword on amazon to search field by using xpath
        driver.findElement(By.xpath("//*[@name='field-keywords' or @id='twotabsearchtextbox']")).sendKeys("laptop");
        //click on search
        driver.findElement(By.xpath("//*[@type='submit' or @value='Go']")).submit();
        //driver.findElement(By.xpath("//*[@value='Go']")).click();
        //driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        //click on the second image item of the same elements within the page
        driver.findElements(By.xpath("//img[contains(@class,'s-image')]")).get(2).click();
        //re navigate to homepage
        //driver.navigate().to("https://www.amazon.com");



    }//end of main method
}//end of java class
