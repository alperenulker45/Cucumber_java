package stepDefinitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.Task2PersonEditPage;
import pages_sample.Task2PersonPage;

public class Task2Steps {

    private WebDriver driver;
    static Task2PersonPage task2PersonPage;
    static Task2PersonEditPage task2PersonEditPage;

    public Task2Steps() {

        this.driver = Hooks.driver;
        task2PersonPage = PageFactory.initElements(Hooks.driver, Task2PersonPage.class);
        task2PersonEditPage = PageFactory.initElements(Hooks.driver, Task2PersonEditPage.class);
    }


    @Given("^I am on the people page$")
    public void iAmOnThePeoplePage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
        driver.manage().window().maximize();
    }

    @When("^I click on the add person button$")
    public void iClickOnTheAddPersonButton() {
        task2PersonPage.clickOnAddPerson();
    }

    @And("^I enter the name \"([^\"]*)\" and surname \"([^\"]*)\"$")
    public void iEnterTheNameAndSurname(String name, String surname){
        task2PersonPage.enterName(name);
        task2PersonPage.enterSurName(surname);
    }

    @And("^I enter the job status \"([^\"]*)\"$")
    public void iEnterTheJobStatus(String job)  {
        task2PersonPage.enterJob(job);
    }

    @And("^I enter the birthday \"([^\"]*)\"$")
    public void iEnterTheBirthday(String birthday)  {
        task2PersonPage.enterBirthday(birthday);
    }

    @And("^I choose my language \"([^\"]*)\"$")
    public void iChooseMyLanguage(String language) {
        task2PersonPage.selectLanguage(language);
    }

    @And("^I choose my gender \"([^\"]*)\"$")
    public void iChooseMyGender(String gender)  {
        task2PersonPage.selectGender(gender);
    }

    @And("^I choose my employee status \"([^\"]*)\"$")
    public void iChooseMyEmployeeStatus(String status) {
        task2PersonPage.selectEmployeeStatus(status);
    }

    @And("^I click on the add button$")
    public void iClickOnTheAddButton() {
        task2PersonPage.clickOnAddBtnAfterFilledForm();
    }


    @Then("^I should see new person added \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iShouldSeeNewPersonAddedAnd(String name, String surname)  {
        task2PersonPage.verifyPersonAdded(name, surname);
    }

    @And("^I click on the reset list button$")
    public void iClickOnTheResetListButton() {
        task2PersonPage.clickOnResetListBtn();
    }

    @Then("^I should see the list reseted$")
    public void iShouldSeeTheListReseted() {
        task2PersonPage.verifyListReseted();
    }


    @When("^I want to edit person name \"([^\"]*)\" surname \"([^\"]*)\"$")
    public void iWantToEditPersonNameSurname(String name, String surname) {
        task2PersonPage.clickOnEditPerson(name, surname);
    }

    @And("^I enter a new name \"([^\"]*)\" and surname \"([^\"]*)\"$")
    public void iEnterANewNameAndSurname(String name, String surname) {
        task2PersonEditPage.enterName(name);
        task2PersonEditPage.enterSurname(surname);

    }

    @And("^I enter a new job status \"([^\"]*)\"$")
    public void iEnterANewJobStatus(String job)  {
        task2PersonEditPage.enterJob(job);
    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() {
        task2PersonEditPage.clickOnEditBtn();
    }

    @Then("^I should see the person edited as name \"([^\"]*)\" and surname \"([^\"]*)\"$")
    public void iShouldSeeThePersonEditedAsNameAndSurname(String name, String surname)  {
        task2PersonPage.verifyTheFirstPersonEdited(name, surname);
    }


    @When("^I want to remove person name \"([^\"]*)\" surname \"([^\"]*)\"$")
    public void iWantToRemovePersonNameSurname(String name, String surname) {
       task2PersonPage.removePerson(name, surname);
    }

    @And("^I should see that the person is removed name \"([^\"]*)\" surname \"([^\"]*)\"$")
    public void iShouldSeeThatThePersonIsRemovedNameSurname(String name, String surname) {
        task2PersonPage.verifyPersonRemoved(name, surname);
    }

    @And("^I click on clear all fields button$")
    public void iClickOnClearAllFieldsButton() {
        task2PersonPage.clickOnClearAllFieldsBtn();
    }

    @Then("^I should see all fields are clear$")
    public void iShouldSeeAllFieldsAreClear() {
        task2PersonPage.checkAllFieldsAreClearAfterClickedOnClearAllFields();
    }
}

