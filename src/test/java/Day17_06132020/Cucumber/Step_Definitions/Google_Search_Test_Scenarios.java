package Day17_06132020.Cucumber.Step_Definitions;

import Reusable_Libraries.Reusable_Library;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Google_Search_Test_Scenarios {

    WebDriver driver;

    /** the annotation gherkin command/method are given are @Given, @When, @And, @Then */
    @Given("^I navigate to google home$")
    public void navigate() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
        driver.navigate().to("https://www.google.com");
    }//end of given

    @When("^I enter keyword (.*) on search field$")
    public void searchField(String Cars) {
        Reusable_Library.userKeys(driver,"//*[@name='q']",Cars,"Search Field");
    }//end clicking

    @When("^I click on search icon$")
    public void searchIcon() {
        Reusable_Library.submit(driver,"//*[@name='btnK']","Search Icon");
    }//end search icon

    @When("^I capture search result and print it$")
    public void searchResult() throws InterruptedException {
        Thread.sleep(2000);
        String result = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Result");
        String[] arraySearch = result.split(" ");
        Reporter.addStepLog("Search number is " + arraySearch[1]);
    }//end capture

    @When("^I click on more icon$")
    public void moreIcon() {
        Reusable_Library.click(driver,"//span[contains(@class,'more-vert')]","more");
    }//end clicking on more

    @When("^I can select the value (.*)$")
    public void moreValue(String More) throws InterruptedException {
        Thread.sleep(2000);
        Reusable_Library.click(driver,"//*[text()='"+More+"']","More Value");
    }//end clicking on more


}//end of java
