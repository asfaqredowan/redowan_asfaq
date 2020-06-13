package Interview_Question;

import Reusable_Libraries.Abstract_Class;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_QA extends Abstract_Class {

    @Test
    public void YahooQA() throws InterruptedException {

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        //search for QA
        driver.findElement(By.xpath("//*[@id='header-search-input']")).sendKeys("QA");

        //inspect search and click
        driver.findElement(By.xpath("//*[@id='header-desktop-search-button']")).click();
        Thread.sleep(2000);
        //scroll down and click QA
        driver.findElement(By.xpath("//*[text()='Quality assurance - Wikipedia']")).click();
        Thread.sleep(2000);
        //define arrayList for new window
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

        //switch to new window
        driver.switchTo().window(newTab.get(1));


        /**page contains the phrase “Middle Ages” */
        boolean Text = driver.getPageSource().contains("Middle Ages");
        if (Text == true) {
            System.out.println("page contains the expected text");
        } else {
            System.out.println("page doesn;t contain expected text");
        }//end of else

        driver.close();
        driver.switchTo().window(newTab.get(0));
    }

}
