package Day10_05102020;

import Day9_05092020.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //locate the readable excel file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resource/Google_Search.xls"));

        //locate worksheet
        Sheet readableSheet = readableFile.getSheet(0);

        //create a writeable workbook to mimic a readable file because we shouldn't write on readable
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/Resource/Google_Search_Result.xls"),readableFile);

        //create writeable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);

        //get the non empty row count
        int rows = writableSheet.getRows();

        //define the web driver using reusable library
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i = 1; i < rows; i++){
            //store the cars column as a string variable
            String cars = writableSheet.getCell(0,i).getContents();

            //navigate to google

            driver.navigate().to("https://www.google.com");

            //wait
            Thread.sleep(2000);

            //reusable library to enter car values on search field
            Reusable_Library.userKeys(driver,"//*[@name='q']",cars,"Search Field");

            //reusable library to click on google search
            Reusable_Library.submit(driver,"//*[@name='btnK']","Google Search");

            //wait
            Thread.sleep(2000);

            String result = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Search Result");
            String[] resultArray = result.split(" ");
            System.out.println("my search number is " + resultArray[i]);

            //write the search number result back to writeable sheet
            Label label = new Label(1,i,resultArray[1] + " " + resultArray[3] + " " + resultArray[4]);
            //adding back to writable cell
            writableSheet.addCell(label);

        }//end of loop

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();

        //quit driver
        driver.quit();




    }//end of main method
}//end of java class
