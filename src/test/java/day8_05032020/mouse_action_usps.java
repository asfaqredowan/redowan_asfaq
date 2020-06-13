package day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class mouse_action_usps {
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
        driver.navigate().to("https://www.usps.com");

        //wait
        Thread.sleep(2000);

        //call mouse action
        Actions mouse = new Actions(driver);

        //hover mouse to mail & ship
        try {
            WebElement mailAndShip = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            //call your actions command to move to the element
            mouse.moveToElement(mailAndShip).perform();
        }catch (Exception e){
            System.out.println("unable to locate Mail & Ship" + e);
        }//end of mail & ship

        //wait
        Thread.sleep(2000);

        //click on click n ship
        try {
            WebElement clickAndShip = driver.findElement(By.xpath("//a[text()='Click-N-Ship']"));
            //WebElement clickAndShip = driver.findElement(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));
            //call your actions command to move to the element
            mouse.moveToElement(clickAndShip).click().perform();
            //to submit using action
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
        }catch (Exception e){
            System.out.println("unable to locate Click & Ship" + e);
        }//end of click n ship



    }//end of main method
}//end of java class
