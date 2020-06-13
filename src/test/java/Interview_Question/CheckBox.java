package Interview_Question;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class CheckBox extends Abstract_Class {

    @Test
    public void CheckBox() throws InterruptedException {
        logger.log(LogStatus.INFO,"CheckBox");

        //navigate
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");
        Thread.sleep(2000);
        //click check boxes
        List<WebElement> elements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("total checkboxes are " + elements.size());
        for (WebElement TotalBox : elements) {
            TotalBox.click();
        } // end for



    }//end of test
}//end of java
