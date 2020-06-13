package Day12_05172020;

import Reusable_Libraries.Reusable_Library;
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

public class Kayak_submit {

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

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException, BiffException {

        //locate readable excel file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//kayak.xls"));
        //locate readable sheet
        Sheet readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//kayak_result.xls"),readableFile);
        //create writable sheet
        wSheet = writableFile.getSheet(0);
        //defined the driver
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    @Test
    public void kayak_actionItem() throws InterruptedException, WriteException {

        int rows = wSheet.getRows();

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
            Reusable_Library.click(driver,"//*[text()='Enter an airport or city']","Search fField");

            //enter the airport
            Reusable_Library.userKeys(driver,"//*[@name='pickup']",airPort,"Search Field");

            //click on the designated airport
            Reusable_Library.mouseClick(driver,"//*[@class='ap-code']","airport");

            //click on end date
            Reusable_Library.mouseClick(driver,"//*[@class='_itL js-end-input']","end date");

            //enter end date
            Reusable_Library.userTypeAndHitEnter(driver,"//*[contains(@id,'-dropoff-date-input')]",endDate,"end date");

            //click outside
            Reusable_Library.click(driver,"//*[@class='title dark']","click on empty space");

            //click on end time
            Reusable_Library.clickByIndex(driver,"//*[@aria-haspopup='listbox']",2,"endTime");

            //enter end time
            Reusable_Library.clickByIndex(driver,"//li[@aria-label='"+endTime+"']",1,"End Time");

            //click on start date
            Reusable_Library.clickByIndex(driver,"//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']",0,"startDate");

            //enter start date
            Reusable_Library.userTypeAndHitEnter(driver,"//div[contains(@id,'pickup-date-input')]",startDate,"start date");

            //click outside
            Reusable_Library.click(driver,"//*[@class='title dark']","click on empty space");

            //enter start time
            Reusable_Library.clickByIndex(driver,"//li[@aria-label='"+startTime+"']",0,"start time");

            Thread.sleep(2000);

            //click on search
            Reusable_Library.click(driver,"//*[@class='_h-2 _ivP _iv1']","search");

            Thread.sleep(4000);

            //select vehicle size
            Reusable_Library.clickByIndex(driver,"//div[contains(@id,'"+vehicleSize+"')]",1,"vehicle size");

            Thread.sleep(4000);

            //click on second index for View Deal
            Reusable_Library.clickByIndex(driver,"//*[text()='View Deal']",2,"view Deal");

            Thread.sleep(3000);

            //define arrayList for new window
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            Thread.sleep(2000);

            //capture vehicle info
            String info = Reusable_Library.captureText(driver, "//*[@class='rental-info', or @class='Checkout-Car-Book-Main-CarSummary', or @class='booking-section']", "Results");

            System.out.println("my vehicle info is " + info);

            //write the error message back to writable sheet
            Label label = new Label(6,i,info);

            //adding back to writable cell
            wSheet.addCell(label);

            //close window
            driver.close();
            //get back to original window
            driver.switchTo().window(tab.get(0));

            Thread.sleep(2000);


            //delete cookies from website
            driver.manage().deleteAllCookies();

        }//end of for loop
    }//end of kayak test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();

    }//end of AfterMethod
}// end of java class
