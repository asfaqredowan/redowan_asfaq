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

public class ActionItem_express {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //WebDriver driver = Reusable_Library.setDriver();

        //locate the readable excel file
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resource/express.xls"));

        //locate worksheet
        Sheet readableSheet = readableFile.getSheet(0);

        //create a writable workbook to mimic a readable file because we shouldn't write on readable
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/Resource/express_result.xls"),readableFile);

        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);

        //get the non empty row count
        int rows = writableSheet.getRows();

        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i = 1; i < rows; i++) {
            //store the size column as string variable
            String size = writableSheet.getCell(0, i).getContents();
            //store the Quantity column as string variable
            String Quantity = writableSheet.getCell(1, i).getContents();
            //store the First name column as string variable
            String firstName = writableSheet.getCell(2, i).getContents();
            //store the last name column as string variable
            String lastName = writableSheet.getCell(3, i).getContents();
            //store the email column as string variable
            String email = writableSheet.getCell(4, i).getContents();
            //store the phone number column as string variable
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            //store the street address column as string variable
            String streetAddress = writableSheet.getCell(6, i).getContents();
            //store the zipcode column as string variable
            String zipCode = writableSheet.getCell(7, i).getContents();
            //store the city column as string variable
            String city = writableSheet.getCell(8, i).getContents();
            //store the state column as string variable
            String state = writableSheet.getCell(9, i).getContents();
            //store the credit card number column as string variable
            String creditCard = writableSheet.getCell(10, i).getContents();
            //store the expire month column as string variable
            String expireMonth = writableSheet.getCell(11, i).getContents();
            //store the expire year column as string variable
            String expireYear = writableSheet.getCell(12, i).getContents();
            //store the CVV column as string variable
            String CVV = writableSheet.getCell(13, i).getContents();
            //store the error message as string variable
            String errorMessage = writableSheet.getCell(14,i).getContents();

            //open web page
            driver.navigate().to("https://www.express.com");

            Thread.sleep(2000);

            //hover to women's section
            //Reusable_Library.mouseHover(driver, "//*[text()='Women']", "women");

            Reusable_Library.mouseHover(driver,"//*[@href='/womens-clothing']","women");

            Thread.sleep(2000);

            //click on dresses
            //Reusable_Library.mouseClick(driver,"//*[text()='Dresses']","dress");

            //Reusable_Library.mouseClick(driver,"//*[@class='_399XX MegaMenuListItem_menuItem__yCJSl']","dress");

            //Reusable_Library.mouseClick(driver,"//*[@class='MegaMenuSubcategory_linkWrapper__3nF4h']","dress");

            Reusable_Library.mouseClick(driver,"//*[@href='/womens-clothing/dresses/cat550007']","dress");

            Thread.sleep(5000);

            //Click on first image
            Reusable_Library.mouseClick(driver,"//*[text()='off the shoulder ruffle maxi dress']","firstImg");

            Thread.sleep(2500);

            //Click on size
            Reusable_Library.mouseClick(driver,"//*[@value='"+size+"']","size");

            Thread.sleep(3000);

            //click on add to bag
            Reusable_Library.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']","add to bag");

            Thread.sleep(2000);

            //click on the bag logo
            Reusable_Library.mouseClick(driver,"//*[@class='DesktopHeader_icons__25y0X ravenDesktopIcons']/div[3]","cart");

            Thread.sleep(2000);

            //click on quantity
            Reusable_Library.dropdownByText(driver,"//*[@class='dropdown__select _2dMWs inputInactive _34Evv']",Quantity,"quantity");

            Thread.sleep(2000);

            //click on checkout
            Reusable_Library.mouseClick(driver,"//*[@id='continue-to-checkout']","checkout");

            Thread.sleep(2000);

            //click on continue as guest
            Reusable_Library.click(driver,"//*[text()='Continue as Guest']","Continue as Guest");

            Thread.sleep(2000);

            //fill up first name field
            //Reusable_Library.mouseClick(driver,"//*[@id='contact-information-firstname']",firstName,"");
            Reusable_Library.userKeys(driver,"//*[@id='contact-information-firstname']",firstName,"firstname");

            //fill up Last name field
            Reusable_Library.userKeys(driver,"//*[@class='ff8oN inputInactive _3qdvz']",lastName,"lastname");

            //fill up email field
            Reusable_Library.userKeys(driver,"//*[@name='email']",email,"email");

            //fill up confirm email field
            Reusable_Library.userKeys(driver,"//*[@name='confirmEmail']",email,"confirm email");

            //fill up phone number
            Reusable_Library.userKeys(driver,"//*[@name='phone']",phoneNumber,"phone");

            //click on continue
            Reusable_Library.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");

            Thread.sleep(2000);

            //fill up street address
            Reusable_Library.userKeys(driver,"//*[@class='ff8oN inputInactive Amh4u']",streetAddress,"street address");

            //fill up postal code
            Reusable_Library.userKeys(driver,"//*[@name='shipping.postalCode']",zipCode,"postal code");

            //fill up city
            Reusable_Library.userKeys(driver,"//*[@name='shipping.city']",city,"city");

            //select state from dropdown
            Reusable_Library.dropdownByText(driver,"//*[@name='shipping.state']",state,"state");

            //click on continue
            Reusable_Library.mouseClick(driver,"//*[text()='Continue']","continue");

            Thread.sleep(1000);

            //click again
            Reusable_Library.mouseClick(driver,"//*[text()='Continue']","continue");

            Thread.sleep(1000);

            //insert credit card number
            Reusable_Library.userKeys(driver,"//*[@id='creditCardNumberInput']",creditCard,"creditCard");

            //select expire month from dropdown
            Reusable_Library.dropdownByText(driver,"//*[@name='expMonth']",expireMonth,"expire month");

            //select expire year from drop down
            Reusable_Library.dropdownByText(driver,"//*[@name='expYear']",expireYear,"expire year");

            //input CVV
            Reusable_Library.userKeys(driver,"//*[@name='cvv']",CVV,"CVV");

            //click on place order
            Reusable_Library.mouseClick(driver,"//*[text()='Place Order']","place order");

            //capture error message
            String result = Reusable_Library.captureText(driver,"//*[@id='rvn-note-NaN']","Result");

            System.out.println("my error message is " + result);

            //write the error message back to writable sheet
            Label label = new Label(14,i,result);


            //adding back to writable cell
            writableSheet.addCell(label);



            driver.manage().deleteAllCookies();
        }//end of for loop

        writableFile.write();
        writableFile.close();
        readableFile.close();

        //quit driver
        driver.quit();

        }//end of main method
}//end of java class
