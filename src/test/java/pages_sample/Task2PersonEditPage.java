package pages_sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task2PersonEditPage {

    @FindBy(how = How.CSS, using = "input#name")
    private WebElement nameInputEdit;

    @FindBy(how = How.CSS, using = "input#surname")
    private WebElement surNameInputEdit;

    @FindBy(how = How.CSS, using = "input#job")
    private WebElement jobInputEdit;

    @FindBy(how = How.CSS, using = "[onclick='editPerson(0)']")
    private WebElement editBtn;

    public void enterName(String name) {
        nameInputEdit.clear();
        nameInputEdit.sendKeys(name);
    }

    public void enterSurname(String surName){
        surNameInputEdit.clear();
        surNameInputEdit.sendKeys(surName);
    }

    public void enterJob(String job) {
        jobInputEdit.clear();
        jobInputEdit.sendKeys(job);
    }

    public void clickOnEditBtn() {
        editBtn.click();
    }

    public WebElement getNameInputEdit() {
        return nameInputEdit;
    }

    public WebElement getSurNameInputEdit() {
        return surNameInputEdit;
    }

    public WebElement getJobInputEdit() {
        return jobInputEdit;
    }

    public WebElement getEditBtn() {
        return editBtn;
    }
}
