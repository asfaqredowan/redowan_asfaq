package day6_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_Options {

    public static void main(String[] args) throws InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for your driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");

        //add wait time if needed
        Thread.sleep(2000);
        //if i want to capture the title of that page
        //System.out.println("my title is " + driver.getTitle());
        //store your actual title variable and then compare with your expected
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("MORTGAGE CALCULATOR & LOAN CALCULATOR")){
            System.out.println("Title matches with expected");
        }else {
            System.out.println("Title doesn't match " + actualTitle);
        }//end of if else method

        //if same locator used more than one than store it as a WebElement variable to reuse it
        WebElement pPrice = driver.findElement(By.xpath("//*[@name ='ma']"));
        //clear the field
        pPrice.clear();
        //enter your new data
        pPrice.sendKeys("666999");

        //store your start month in WebElement and call it on your Select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //call my selected command
        Select sMonthList = new Select(sMonth);
        //select the drop down value by visible text
        sMonthList.selectByVisibleText("Jul");
        //sMonthList.deselectByIndex(7);
        //sMonthList.deselectByValue("6");

        //lets verify some of the start year to make its matching on the drop down
        String[] yearArray = new String[]{"2005","2015","2035"};
        for (int i = 0; i < yearArray.length; i++) {


            //store your start year
            //WebElement sYear = driver.findElement(By.xpath("//*[@name='sy']"));
            driver.findElement(By.xpath("//*[@name='sy']")).click();
            //wait
            Thread.sleep(2000);

            //Select sYearList = new Select(sYear);
            //sYearList.selectByValue("2021");
            //driver.findElement(By.xpath("//*[text()='2021']")).click();
            driver.findElement(By.xpath("//*[text()='"+yearArray[i]+"']")).click();


        }//end of loop
    }//end of main method
}//end of java class
