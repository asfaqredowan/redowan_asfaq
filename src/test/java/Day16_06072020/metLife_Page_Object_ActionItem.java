package Day16_06072020;

import Merlife_Page_Object.MetLife_Base_Class;
import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class metLife_Page_Object_ActionItem extends Abstract_Class {

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
            /** mouse hoover on solutions */
            MetLife_Base_Class.metLife_homepage().Solutions();

            Thread.sleep(2000);

            /**click on MetLife TakeAlong Dental */
            MetLife_Base_Class.metLife_homepage().TakeAlongDental();

            //verify title
            Reusable_Library_Logger.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife",logger);
            Thread.sleep(2000);

            /** click on enroll now */
            MetLife_Base_Class.metLife_homepage().EnrollNow();

            //define the ArrayList to all current tabs that are open
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second window
            driver.switchTo().window(tabs.get(1));
            //wait
            Thread.sleep(2000);

            /** enter zipcode */
            MetLife_Base_Class.metLife_homepage().zipCode(zipCode.get(i));

            /** click on go */
            MetLife_Base_Class.metLife_homepage().GO();
            Thread.sleep(2000);

            //click on dental PPO
            Reusable_Library_Logger.click(driver,"//*[@class='" + dentalProgram.get(i) + "']","PPO",logger);

            /** click on enroll */
            MetLife_Base_Class.metLife_homepage().enroll();
            Thread.sleep(2000);

            /** enter referral code */
            MetLife_Base_Class.metLife_homepage().referral(referralCode.get(i));

            /** click go */
            MetLife_Base_Class.metLife_homepage().refGo();
            Thread.sleep(2000);

            /** capture error massage */
            MetLife_Base_Class.metLife_search_result_page().errorMassage();
            Thread.sleep(2000);

            /** click enroll without code */
            MetLife_Base_Class.metLife_homepage().noRef();

            /** capture text */
            MetLife_Base_Class.metLife_search_result_page().text();
            driver.switchTo().window(tabs.get(0));
            //driver.manage().deleteAllCookies();




        }//end of for loop

    }//end of test

}//end of java class
