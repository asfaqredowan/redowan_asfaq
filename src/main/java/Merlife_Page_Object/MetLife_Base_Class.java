package Merlife_Page_Object;

import Reusable_Libraries.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Homepage;
import Yahoo_Page_Object.Yahoo_Search_Result_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Base_Class extends Abstract_Class {
    /** constructor class is defined to call local driver and set it to
        the driver from abstract class
     */
    public MetLife_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor

    /** method/object is created to make the page classes static
        by referencing as a new name similar to the actual page class name
     */

    /** object/method for metLife home page */
    public static MetLife_Homepage metLife_homepage(){
        MetLife_Homepage metLife_homepage = new MetLife_Homepage(driver);
        return metLife_homepage;
    }//end of object reference for yahoo homepage

    /** object/method for yahoo search result page */
    public static MetLife_Search_Result_Page metLife_search_result_page(){
        MetLife_Search_Result_Page metLife_search_result_page = new MetLife_Search_Result_Page(driver);
        return metLife_search_result_page;
    }//end of object reference for yahoo search result page


}//end of java class
