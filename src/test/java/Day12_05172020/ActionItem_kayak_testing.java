package Day12_05172020;

import Reusable_Libraries.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionItem_kayak_testing {

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

            Thread.sleep(2000);

            //click airport or city
            //Reusable_Library.click(driver,"//*[@data-placeholder='Enter an airport or city']","Search Field");
            Reusable_Library.click(driver,"//*[text()='Enter an airport or city']","Search fField");

            Thread.sleep(2000);

            //enter the airport
            Reusable_Library.userKeys(driver,"//*[@name='pickup']",airPort,"Search Field");

            //click on the designated airport
            Reusable_Library.mouseClick(driver,"//*[@class='ap-code']","airport");

            Thread.sleep(2000);

            //click on end date
            Reusable_Library.mouseClick(driver,"//*[@class='_itL js-end-input']","end date");

            Thread.sleep(2000);

            //enter end date
            //Reusable_Library.userTypeAndHitEnter(driver,"//*[@class='_itL js-end-input']",endDate,"end date");
            Reusable_Library.userTypeAndHitEnter(driver,"//*[contains(@id,'-dropoff-date-input')]",endDate,"end date");

            //click outside
            Reusable_Library.mouseClick(driver,"//*[@class='form-section']","click on empty space");

            Thread.sleep(2000);

            //click on end time
            Reusable_Library.clickByIndex(driver,"//div[@class='_id7 _irc _ii0 _iir']",1,"end time");
            //Reusable_Library.clickByIndex(driver,"//div[@class='_iKm _id7 _iOC _iFZ _iA6 _iFW']",2,"end time");

            Thread.sleep(2000);

            //enter end time
            //Reusable_Library.userTypeAndHitEnter(driver,"//div[@class='_id7 _irc _ii0 _iir']",endTime,"end time");
            Reusable_Library.clickByIndex(driver,"//li[@aria-label='"+endTime+"']",1,"End Time");

            Thread.sleep(2000);

            //click outside
            Reusable_Library.mouseClick(driver,"//*[@class='form-section']","click on empty space");

            //click on start date
            //Reusable_Library.mouseClick(driver,"//*[@class='startDate _id7 _ijM _idA _ioF _ii0 _j0G _iQh']","date");
            Reusable_Library.mouseClick(driver,"//div[@id='qSmQ-dateRangeInput-display-start-inner']","start date");

            //enter date
            //Reusable_Library.userTypeAndHitEnter(driver,"//div[@id='vbGS-pickup-date-input']",startDate,"date");
            Reusable_Library.userTypeAndHitEnter(driver,"//div[contains(@id,'pickup-date-input')]",startDate,"start date");

            Thread.sleep(2000);

            //click outside
            Reusable_Library.mouseClick(driver,"//*[@class='form-section']","click on empty space");

            //click on start time
            //Reusable_Library.clickByIndex(driver,"//*[@class='_iKN _j0E _iQh _j0F']",0,"start time");

            Thread.sleep(2000);

            //enter start time
            Reusable_Library.clickByIndex(driver,"//li[@aria-label='"+startTime+"']",0,"start time");

            //click on search
            Reusable_Library.mouseClick(driver,"//*[@id='T4I7-submit-wrapper']","search");

            //select vehicle size
            Reusable_Library.mouseClick(driver,"//*[@class='cars-results-filters-CarTopFilters']",vehicleSize);



        }//end of for loop
    }//end of google test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of AfterMethod
}
