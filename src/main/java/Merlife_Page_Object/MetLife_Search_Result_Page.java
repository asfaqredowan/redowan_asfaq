package Merlife_Page_Object;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Search_Result_Page extends Abstract_Class {

    /** declaring local logger to this page class */
    ExtentTest logger;

    /** constructor method to handle local driver and logger equal to driver and
        logger from abstract class
     */
    public MetLife_Search_Result_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor

    /** method to capture error message     */
    public MetLife_Search_Result_Page errorMassage(){
        Reusable_Library_Logger.captureText(driver,"//*[@id='lblRefCodeError']","error massage",logger);
        return new MetLife_Search_Result_Page (driver);
    }

    /** method to capture text */
    public MetLife_Search_Result_Page text(){
        Reusable_Library_Logger.captureText(driver,"//*[@class='col-sm-8']","capture text",logger);
        return new MetLife_Search_Result_Page(driver);
    }


}//end of java class
