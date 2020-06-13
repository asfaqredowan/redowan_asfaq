package Reusable_Libraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class Reusable_Library_Logger {

     static int timeout = 15;


     //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws InterruptedException, IOException {
        //kill the chromedriver instance
        Thread.sleep(1800);
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver83.exe /T");
        Thread.sleep(2000);
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver,String expectedTitle, ExtentTest logger){
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Expected title matches with Actual " + expectedTitle);
            logger.log(LogStatus.INFO,"Expected title matches with Actual " + expectedTitle);
        } else {
            System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Expected doesn't match actual title. Actual title is " + actualTitle);
        }
    }//end of verify title method




    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
              WebDriverWait wait = new WebDriverWait(driver,timeout);
              try{
                  System.out.println("Selecting a value on element " + elementName);
                  logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
                  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                  Select dDown = new Select(element);
                  dDown.selectByVisibleText(userInput);
              } catch (Exception e) {
                System.out.println("Unable to select element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
                  getScreenShot(driver,logger,elementName);
             }
    }//end of drop down by text method



    //method to enter user input on send keys
    public static void userKeys(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering value on element");
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to enter element" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of send keys method



    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method



    //method to submit on an element
    public static void submit(WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Submitting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of submit method



    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            System.out.println("Capturing a text from element " + elementName);
            logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

        return result;

    }//end of click method




    //method for mouse hover
    public static void mouseHover (WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Hovering inside element " + elementName);
            logger.log(LogStatus.INFO,"Hovering inside element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }catch (Exception e) {
            System.out.println("Unable to hover " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of mouse hover



    //mouse click
    public static void mouseClick  (WebDriver driver,String locator,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
        }catch (Exception e) {
            System.out.println("Unable to click " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of mouse click



    //method to click by index on an element
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click by index " + index +  " on element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click by index method




    //method to enter user input on send keys
    public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.FAIL,"Entering a value on element " + elementName);
            Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            Reporter.log("Unable to enter element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of userTypeAndHitEnter method



    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//HTML_Report//Screenshots//";
            File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of screenshot method





}//end of java class
