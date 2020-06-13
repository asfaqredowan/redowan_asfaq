package Day14_05312020;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Library;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ActionItem_kayak_Abstract extends Abstract_Class {

    //on all my annotation method
    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;
    //
    ExtentReports reports;
    //
    ExtentTest logger;

    @Test
    public void kayak_actionItem() throws InterruptedException, WriteException, IOException, BiffException {

        //locate readable excel file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//kayak.xls"));

        //locate readable sheet
        Sheet readableSheet = readableFile.getSheet(0);

        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//kayak_result.xls"),readableFile);

        //create writable sheet
        wSheet = writableFile.getSheet(0);

        //define the report path
        reports = new ExtentReports("src//main//java//HTML_Report//Kayak.html",true);


        int rows = wSheet.getRows();
        logger = reports.startTest("Kayak Search Result");

        for(int i = 1; i < rows; i++) {
            
            //store the airport column as string variable
            String airPort = wSheet.getCell(0,i).getContents();
            //store the start date column as string variable
            String startDate = wSheet.getCell(1,i).getContents();
            //store the start time column as string variable
            String startTime = wSheet.getCell(2,i).getContents();
            //store the end date column as string variable
            String endDate = wSheet.getCell(3,i).getContents();
            //store the end time column as string variable
            String endTime = wSheet.getCell(4,i).getContents();
            //store the vehicle size column as string variable
            String vehicleSize = wSheet.getCell(5,i).getContents();
            //store the vehicle info column as string variable
            String vehicleInfo = wSheet.getCell(6,i).getContents();

            //navigate to kayak.com
            driver.navigate().to("https://www.kayak.com");

            Thread.sleep(3000);

            //click airport or city
            //Reusable_Library.click(driver,"//*[@data-placeholder='Enter an airport or city']","Search Field");
            Reusable_Library_Logger.click(driver,"//*[text()='Enter an airport or city']","Search fField",logger);

            Thread.sleep(2000);

            //enter the airport
            Reusable_Library_Logger.userKeys(driver,"//*[@name='pickup']",airPort,"Search Field",logger);

            //click on the designated airport
            Reusable_Library_Logger.mouseClick(driver,"//*[@class='ap-code']","airport",logger);

            Thread.sleep(2000);

            //click on end date
            Reusable_Library_Logger.mouseClick(driver,"//*[@class='_itL js-end-input']","end date",logger);

            Thread.sleep(2000);

            //enter end date
            //Reusable_Library.userTypeAndHitEnter(driver,"//*[@class='_itL js-end-input']",endDate,"end date");
            Reusable_Library_Logger.userTypeAndHitEnter(driver,"//*[contains(@id,'-dropoff-date-input')]",endDate,"end date",logger);

            Thread.sleep(3000);

            //click outside
            Reusable_Library_Logger.click(driver,"//*[@class='title dark']","click on empty space",logger);


            //click on end time
            Reusable_Library_Logger.clickByIndex(driver,"//*[@aria-haspopup='listbox']",2,"endTime",logger);
            //Reusable_Library.clickByIndex(driver,"//div[@class='_iKm _id7 _iOC _iFZ _iA6 _iFW']",2,"end time");

            Thread.sleep(2000);

            //enter end time
            //Reusable_Library.userTypeAndHitEnter(driver,"//div[@class='_id7 _irc _ii0 _iir']",endTime,"end time");
            Reusable_Library_Logger.clickByIndex(driver,"//li[@aria-label='"+endTime+"']",1,"End Time",logger);

            Thread.sleep(2000);

            //click on start date
            //Reusable_Library.mouseClick(driver,"//*[@class='startDate _id7 _ijM _idA _ioF _ii0 _j0G _iQh']","date");
            //Reusable_Library.mouseClick(driver,"//div[@id='qSmQ-dateRangeInput-display-start-inner']","start date");
            Reusable_Library_Logger.clickByIndex(driver,"//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']",0,"startDate",logger);

            Thread.sleep(1000);

            //enter start date
            //Reusable_Library.userTypeAndHitEnter(driver,"//div[@id='vbGS-pickup-date-input']",startDate,"date");
            Reusable_Library_Logger.userTypeAndHitEnter(driver,"//div[contains(@id,'pickup-date-input')]",startDate,"start date",logger);

            Thread.sleep(2000);

            //click outside
            Reusable_Library_Logger.click(driver,"//*[@class='title dark']","click on empty space",logger);

            //click on start time
            //Reusable_Library.clickByIndex(driver,"//*[@class='_iKN _j0E _iQh _j0F']",0,"start time");


            //enter start time
            Reusable_Library_Logger.clickByIndex(driver,"//li[@aria-label='"+startTime+"']",0,"start time",logger);

            Thread.sleep(2000);

            //click outside
            //Reusable_Library.click(driver,"//*[@class='form-section']","click on empty space");

            //click on search
            Reusable_Library_Logger.click(driver,"//*[@class='_h-2 _ivP _iv1']","search",logger);

            Thread.sleep(4000);

            //select vehicle size
            Reusable_Library_Logger.clickByIndex(driver,"//div[contains(@id,'"+vehicleSize+"')]",1,"vehicle size",logger);

            Thread.sleep(4000);

            //click on second index for View Deal
            Reusable_Library_Logger.clickByIndex(driver,"//*[text()='View Deal']",2,"view Deal",logger);

            Thread.sleep(3000);

            //define arrayList for new window
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            Thread.sleep(2000);

            String info = Reusable_Library.captureText(driver, "//*[@class='rental-info', or @class='Checkout-Car-Book-Main-CarSummary', or @class='booking-section']", "Results");

            System.out.println("my vehicle info is " + info);

            //write the error message back to writable sheet
            Label label = new Label(6,i,info);


            //adding back to writable cell
            wSheet.addCell(label);

            driver.close();
            driver.switchTo().window(tab.get(0));

            Thread.sleep(2000);


            //delete cookies from website
            driver.manage().deleteAllCookies();
        }//end of for loop
            reports.endTest(logger);
        writableFile.write();
        writableFile.close();
        readableFile.close();
    }//end of kayak test

}// end of java class
