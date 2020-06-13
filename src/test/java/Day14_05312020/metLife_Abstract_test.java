package Day14_05312020;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class metLife_Abstract_test extends Abstract_Class {

    @Test
    public void metLife() throws InterruptedException {
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10304");
        zipCode.add("10475");

        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("123");
        referralCode.add("420");
        referralCode.add("690");

        logger.log(LogStatus.INFO,"MetLife");

        for (int i = 0; i < 3; i++){

            driver.navigate().to("https://www.metlife.com");
            Thread.sleep(2000);

            //get title
            Reusable_Library_Logger.verifyTitle(driver,"Insurance & Employee Benefit | MetLife",logger);
            //mouse hoover on solutions
            Reusable_Library_Logger.mouseClick(driver,"//*[@class='header__navigation-container-menu-item']","SOLUTIONS",logger);
            //Reusable_Library_Logger.click(driver,"/*[contains(text(),'SOLUTIONS')]","Solutions",logger);
            Thread.sleep(2000);

            //click on MetLife TakeAlong Dental
            //Reusable_Library_Logger.click(driver,"//*[@href='/insurance/dental-insurance/takealongdental/']","dental",logger);
            Reusable_Library_Logger.click(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","MetLife takealong dental",logger);

            //verify title
            Reusable_Library_Logger.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife",logger);
            Thread.sleep(2000);

            //click on enroll now
            Reusable_Library_Logger.click(driver,"//*[contains(text(),'Enroll Now')]","enroll now",logger);
            Thread.sleep(2000);

            //define the ArrayList to all current tabs that are open
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second window
            driver.switchTo().window(tabs.get(1));
            //wait
            Thread.sleep(2000);

            //enter zipcode
            Reusable_Library_Logger.userTypeAndHitEnter(driver,"//*[@id='txtZipCode']",zipCode.get(i),"zipcode",logger);
            //click on go
            Reusable_Library_Logger.click(driver,"//*[@id='txtZipCodetxt']","GO",logger);
            Thread.sleep(2000);

            //click on dental PPO
            Reusable_Library_Logger.click(driver,"//*[@class='" + dentalProgram.get(i) + "']","PPO",logger);
            //click on enroll
            Reusable_Library_Logger.click(driver,"//*[@id='topenrolltab']","enroll",logger);
            Thread.sleep(2000);

            //enter referral code
            Reusable_Library_Logger.userTypeAndHitEnter(driver,"//*[@id='txtBxPromocode']",referralCode.get(i),"referral code",logger);
            //click go
            Reusable_Library_Logger.click(driver,"//*[@id='enrollgobtn']","go",logger);
            Thread.sleep(2000);

            //capture error massage
            Reusable_Library_Logger.captureText(driver,"//*[@id='lblRefCodeError']","error massage",logger);
            Thread.sleep(2000);

            //click enroll without code
            Reusable_Library_Logger.click(driver,"//*[@id='withoutrefcode']","enroll without code",logger);
            //capture text
            Reusable_Library_Logger.captureText(driver,"//*[@class='col-sm-8']","capture text",logger);
            driver.switchTo().window(tabs.get(0));
            //driver.manage().deleteAllCookies();




        }//end of for loop

    }//end of test

}//end of java class
