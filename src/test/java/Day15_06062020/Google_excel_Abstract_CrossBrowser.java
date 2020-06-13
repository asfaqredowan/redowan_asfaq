package Day15_06062020;


import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Abstract_Class_Parameter;
import Reusable_Libraries.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Google_excel_Abstract_CrossBrowser extends Abstract_Class_Parameter {


    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;

    @Test
    public void Google_excel() throws InterruptedException, WriteException, IOException, BiffException {


        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//class.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//class_result.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);

        logger.log(LogStatus.INFO,"Google Excel");

        int row = wSheet.getRows();
        for(int i = 1; i < row; i++) {
            String cars = wSheet.getCell(0,i).getContents();
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            //enter keyword car on my search field
            Reusable_Library_Logger.userKeys(driver, "//*[@name='q']", cars, "Search Field",logger);
            //click on submit
            Reusable_Library_Logger.submit(driver, "//*[@name='btnK']", "Google Search Button",logger);
            Thread.sleep(2000);
            //capture text and print out the search number
            String searchResult = Reusable_Library_Logger.captureText(driver, "//*[@id='result-stats']", "Search Results",logger);
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            //Reporter.log("My search number for car is " + arraySearch[1]);
            System.out.println("My search number for car is " + arraySearch[1]);
            //add the label
            Label label = new Label(1,i,arraySearch[1]);
            wSheet.addCell(label);
        }//end of for loop
        writableFile.write();
        writableFile.close();
        readableFile.close();
    }//end of google test


}//end of java class
