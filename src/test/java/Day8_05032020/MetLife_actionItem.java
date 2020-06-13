package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class MetLife_actionItem {
    public static void main(String[] args) throws InterruptedException {
        //set chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some condition
        ChromeOptions options = new ChromeOptions();
        //add some arguments on chrome driver
        options.addArguments("start-maximized", "incognito");
        //define chrome driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to destination
        //driver.navigate().to("https://www.metlife.com");

        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10304");
        zipCode.add("10475");

        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("123");
        referralCode.add("420");
        referralCode.add("690");


        for (int i = 0; i < dentalProgram.size(); i++) {

            driver.navigate().to("https://www.metlife.com");

            //wait
            Thread.sleep(2000);

            String titlepage = driver.getTitle();
            //get title
            if (titlepage.equals("Insurance & Employee Benefit | Metlife")){
                System.out.println("my expected title matches the original");
            }else {
                System.out.println("title doesn't match with expected " + titlepage);
            }//end of if method

            try {
                driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on SOLUTIONS" + e);
            }//end of SOLUTION exception

            //wait
            Thread.sleep(2000);

            try {
                driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on MetLife TakeAlong Dental" + e);
            }//end of MetLife TakeAlong Dental exception

            //wait
            Thread.sleep(2000);

            String dentaltakealong = driver.getTitle();

            //get title
            if (dentaltakealong.equals("MetLife TakeAlong Dental | MetLife")){
                System.out.println("my expected title matches the original");
            }else {
                System.out.println("title doesn't match with expected " + dentaltakealong);
            }//end of if method

            //wait
            Thread.sleep(2000);

            //click on enroll now
            try {
                driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on Enroll Now" + e);
            }//end of Enroll Now exception

            //define the ArrayList to all current tabs that are open
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            //switch to second window
            driver.switchTo().window(tabs.get(1));

            //wait
            Thread.sleep(2000);

            //enter zipcode
            try {
                WebElement ZipCode = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
                ZipCode.clear();
                ZipCode.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("unable to enter on search field" + e);
            }//end of Zipcode exception

            //click on go
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on Enroll Now" + e);
            }//end of go excception

            //wait
            Thread.sleep(6000);

            //click of dental PPO
            try {
                driver.findElement(By.xpath("//*[@class='"+dentalProgram.get(i)+"']")).click();
            } catch (Exception e) {
                System.out.println("unable to click and select PPO" + e);
            }//end of try and catch

            //click on enroll
            try {
                driver.findElement(By.xpath("//*[@id='topenrolltab']")).click();
            } catch (Exception e) {
                System.out.println("unable to click and select PPO" + e);
            }//end of try and catch to click on enroll

            Thread.sleep(2000);

            //input referral code
            try {
                WebElement code = driver.findElement(By.xpath("//*[@id='txtBxPromocode']"));
                code.sendKeys(referralCode.get(i));
            } catch (Exception e) {
                System.out.println("unable to click and select PPO" + e);
            }//end of try and catch for inputting referral code

            Thread.sleep(2000);

            //press go
            try {
                driver.findElement(By.xpath("//*[@id='enrollgobtn']")).click();
            } catch (Exception e) {
                System.out.println("unable to click and select PPO" + e);
            }//end of try and catch for pressing go

            Thread.sleep(2000);

            //capture error massage
            try {
                WebElement massage = driver.findElement(By.xpath("//*[@id='lblRefCodeError']"));
                massage.getText();
                System.out.println("my error massage is " + massage.getText());
            } catch (Exception e) {
                System.out.println("unable to get text " + e);
            }//end of try & catch to capture error massage

            Thread.sleep(2000);

            //press enroll without code
            try {
                driver.findElement(By.xpath("//*[@id='withoutrefcode']")).click();
            } catch (Exception e) {
                System.out.println("unable to click and select PPO" + e);
            }//end of try & catch to click enroll

            Thread.sleep(2000);

            //capture massage
            try {
                WebElement actualresult = driver.findElement(By.xpath("//*[@class='col-sm-8']"));
                if (actualresult.getText().contains(dentalProgram.get(i))){
                    System.out.println("actual PPO match with expected " + actualresult.getText());
                }else {
                    System.out.println("PPO does not match with expected");
                }
            } catch (Exception e) {
                System.out.println("unable to capture PPO" + e);
            }//end of if for capture

            //wait
            Thread.sleep(1500);

            //close the tab
            driver.close();

            //switch to second window
            driver.switchTo().window(tabs.get(0));


        }//end of for loop
    }//end of main method
}//end of java class
