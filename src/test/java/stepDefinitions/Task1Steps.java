package stepDefinitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;


public class Task1Steps {

    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the number page$")
    public void iAmOnTheNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
    }

    @When("^I enter \"([^\"]*)\" to the number box$")
    public void iEnterToTheNumberBox(String num) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(num);
    }

    @And("^I click on the submit button$")
    public void iClickOnTheSubmitButton() {
        driver.findElement(By.cssSelector(".w3-orange")).click();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSee(String message) {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I should see success message$")
    public void iShouldSeeSuccessMessage() {
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alert.getText());
    }
}
