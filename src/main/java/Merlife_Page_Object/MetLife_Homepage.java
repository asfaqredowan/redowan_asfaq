package Merlife_Page_Object;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Homepage extends Abstract_Class {

    /** declare ExtentTest so you can use it locally **/
    ExtentTest logger;

    /** we need to create a constructor method that defines
    driver and logger to be reuse locally to this page class
    ..constructor inherits same name as your java parent class
    */
    public MetLife_Homepage(WebDriver driver){
        /** super() command define the driver and logger variable
            you need locally which is coming from abstract class
         */
        super();

        /** PageFactory.initElements allows you to set a local driver to
            equal to your driver coming from abstract class by using 'this'
            command to indicate you are using the driver in this page class
         */
        PageFactory.initElements(driver,this);

        /** local page logger gets set to abstract class 'logger' when you
           use it in page object concept
         */
        this.logger = super.logger;
    }//end of constructor

    /** method for Solution */
    public MetLife_Homepage Solutions(){
        Reusable_Library_Logger.mouseClick(driver,"//*[@class='header__navigation-container-menu-item']","SOLUTIONS",logger);
        return new MetLife_Homepage(driver);
        /** the driver that i used is returning you the same
            metLife_homepage
         */
    }//end of solution

    /** method for take along dental */
    public MetLife_Homepage TakeAlongDental(){
        Reusable_Library_Logger.mouseClick(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","MetLife takeAlong dental",logger);
        return new MetLife_Homepage(driver);

    }//end of takeAlong dental

    /** method for clicking on enroll now */
    public MetLife_Homepage EnrollNow(){
        Reusable_Library_Logger.click(driver,"//*[contains(text(),'Enroll Now')]","enroll now",logger);
        return new MetLife_Homepage(driver);
    }

    /** method to enter zipcode */
    public MetLife_Homepage zipCode(String userValue){
        Reusable_Library_Logger.userKeys(driver,"//*[@id='txtZipCode']",userValue,"zipcode",logger);
        return new MetLife_Homepage(driver);
    }

    /** method to click on go */
    public MetLife_Homepage GO(){
        Reusable_Library_Logger.click(driver,"//*[@id='txtZipCodetxt']","GO",logger);
        return new MetLife_Homepage(driver);
    }

    /* method to click dental PPO
    public MetLife_Homepage PPO(String userValue){
        Reusable_Library_Logger.userKeys();
    } */

    /** method to click enroll */
    public MetLife_Homepage enroll(){
        Reusable_Library_Logger.click(driver,"//*[@id='topenrolltab']","enroll",logger);
        return new MetLife_Homepage(driver);
    }

    /** method to enter referral code */
    public MetLife_Homepage referral(String userValue){
        Reusable_Library_Logger.userKeys(driver,"//*[@id='txtBxPromocode']",userValue,"referral code",logger);
        return new MetLife_Homepage(driver);
    }

    /** method to click go     */
    public MetLife_Homepage refGo(){
        Reusable_Library_Logger.click(driver,"//*[@id='enrollgobtn']","go",logger);
        return new MetLife_Homepage(driver);
    }

    /** method to click enroll without code */
    public MetLife_Homepage noRef(){
        Reusable_Library_Logger.click(driver,"//*[@id='withoutrefcode']","enroll without code",logger);
        return new MetLife_Homepage(driver);
    }


}//end of java class
