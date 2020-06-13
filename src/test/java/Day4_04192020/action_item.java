package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class action_item {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //you declare and define web driver
        WebDriver driver = new ChromeDriver();
        //create a dynamic array for city to loop through certain values from the array
        String[] team = new String[5];
        team[0] = "Real Madrid";
        team[1] = "Juventus";
        team[2] = "Manchester united";
        team[3] = "Chelsea";
        team[4] = "Inter milan";
        //this is where u will start ur loop from navigate up until before quit
        for (int i = 0; i < team.length; i++) {

            //opening the browser automatically
            driver.navigate().to("http://www.bing.com");
            //maximize your browser
            driver.manage().window().maximize();
            //sleep statements handle in milliseconds
            Thread.sleep(2000);
            //locate the search field by inspection it first and then enter a keyword
            driver.findElement(By.id("sb_form_q")).sendKeys(team[i]);

            //press "enter" for bing search
            driver.findElement(By.id("sb_form_q")).submit();
            Thread.sleep(2000);

            //to capture text from website you need to
            String message = driver.findElement(By.className("sb_count")).getText();
            //using array variables to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("My favorite team  is " + team[i] + " and search number is " + arrayResult[0]);


        }//end of for loop
        //quit the session
        driver.quit();
    }//end of main method
}//end of java class
