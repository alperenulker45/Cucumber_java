package pages_sample;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static org.junit.Assert.*;

public class Task2PersonPage {

    @FindBy(how = How.XPATH, using = "//button[@onclick='openModalForAddPerson()']")
    private WebElement addPersonBtn;

    @FindBy(how = How.CSS, using = ".fa-pencil")
    private List<WebElement> editPersnBtns;

    @FindBy(how = How.ID, using= "name")
    private WebElement nameInput;

    @FindBy(how = How.ID, using= "surname")
    private WebElement surNameInput;

    @FindBy(how = How.ID, using= "job")
    private WebElement jobInput;

    @FindBy(how = How.ID, using= "dob")
    private WebElement birthDayinput;

    @FindBy(how = How.CSS, using= "[type=checkbox]#english")
    private WebElement checkBoxEnglish;

    @FindBy(how = How.CSS, using= "[type=checkbox]#spanish")
    private WebElement checkBoxSpanish;

    @FindBy(how = How.CSS, using= "[type=checkbox]#french")
    private WebElement checkBoxFrench;

    @FindBy(how = How.CSS, using= "[name='gender']")
    private List<WebElement> genders;

    @FindBy(how = How.XPATH, using= "//select[@class='w3-select']")
    private WebElement empStatsDD;

    @FindBy(how = How.CSS, using= "#modal_button[onclick='addPersonToList()']")
    private WebElement addBtnAfterForm;

    @FindBy(how = How.CSS, using= "#modal_button[onclick='window.history.back()']")
    private WebElement cancelBtnAfterForm;

    @FindBy(how = How.CSS, using= "[onclick='openModalForAddPerson()']")
    private WebElement clearAllFieldsBtn;

    @FindBy(how = How.CSS, using= ".name")
    private List<WebElement> nameList;

    @FindBy(how = How.CSS, using= ".surname")
    private List<WebElement> surNameList;

    @FindBy(how = How.CSS, using= "[onclick='resetListOfPeople()']")
    private WebElement resetListBtn;

    @FindBy(how = How.CSS, using= ".closebtn")
    private List<WebElement> removePersonList;


    public void clickOnAddPerson() {
        addPersonBtn.click();
    }

    public void clickOnEditPerson(String name, String surname) {
        for (int i = 0; i <nameList.size() ; i++) {
            if(nameList.get(i).getText().equalsIgnoreCase(name) &&
            surNameList.get(i).getText().equalsIgnoreCase(surname)) {
                editPersnBtns.get(i).click();
            }
        }
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterSurName(String surName) {
        surNameInput.clear();
        surNameInput.sendKeys(surName);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void enterBirthday(String birthday) {
        birthDayinput.clear();
        birthDayinput.sendKeys(birthday);
    }

    public void selectLanguage(String language) {
        switch (language) {
            case "English" :
                if(!checkBoxEnglish.isSelected()) {
                    checkBoxEnglish.click();
                }
                break;

            case "Spanish" :
                if(!checkBoxSpanish.isSelected()) {
                    checkBoxSpanish.click();
                }
                break;

            case "French" :
                if(!checkBoxFrench.isSelected()) {
                    checkBoxFrench.click();
                }
                break;
        }

    }

    public void selectGender(String gender) {
        switch (gender) {
            case "Male" :
                genders.get(0).click();
                break;

            case "Female" :
                genders.get(1).click();
                break;
        }
    }

    public void selectEmployeeStatus(String option) {
        Select select = new Select(empStatsDD);
        select.selectByVisibleText(option);
    }

    public void clickOnAddBtnAfterFilledForm() {
        addBtnAfterForm.click();
    }

    public void verifyPersonAdded(String name, String surname) {
        assertTrue(name.equalsIgnoreCase(nameList.get(nameList.size()-1).getText()));
        assertTrue(surname.equalsIgnoreCase(surNameList.get(surNameList.size()-1).getText()));
    }

    public void clickOnResetListBtn(){
        resetListBtn.click();
    }

    public void verifyListReseted() {
        assertTrue(nameList.size()==3);
        assertEquals("Mike", nameList.get(0).getText());
        assertEquals("Kid", surNameList.get(0).getText());
        assertEquals("Jill", nameList.get(1).getText());
        assertEquals("Watson", surNameList.get(1).getText());
        assertEquals("Jane", nameList.get(2).getText());
        assertEquals("Doe", surNameList.get(2).getText());
    }

    public void verifyTheFirstPersonEdited(String name, String surname){
        assertEquals(name, nameList.get(0).getText());
        assertEquals(surname, surNameList.get(0).getText());
    }


    public void removePerson(String name, String surname) {
            for (int i = 0; i <nameList.size() ; i++) {
                if(nameList.get(i).getText().equalsIgnoreCase(name) &&
                        surNameList.get(i).getText().equalsIgnoreCase(surname)) {
                    removePersonList.get(i).click();
                }
            }
    }

    public void verifyPersonRemoved(String name, String surname) {
        for (WebElement e : nameList) {
            assertNotEquals(name, e.getText());
        }

        for (WebElement e : surNameList) {
            assertNotEquals(surname, e.getText());
        }
    }

    public void checkAllFieldsAreClearAfterClickedOnClearAllFields() {
        assertEquals("", nameInput.getAttribute("value"));
        assertEquals("", surNameInput.getAttribute("value"));
        assertEquals("", jobInput.getAttribute("value"));
        assertEquals("", birthDayinput.getAttribute("value"));
        assertTrue(checkBoxEnglish.isSelected());
        assertFalse(checkBoxFrench.isSelected());
        assertFalse(checkBoxSpanish.isSelected());
        assertFalse(genders.get(0).isSelected());
        assertFalse(genders.get(1).isSelected());
    }

    public void clickOnClearAllFieldsBtn() {
        clearAllFieldsBtn.click();
    }

    public WebElement getAddPersonBtn() {
        return addPersonBtn;
    }

    public List<WebElement> getEditPersnBtns() {
        return editPersnBtns;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getSurNameInput() {
        return surNameInput;
    }

    public WebElement getJobInput() {
        return jobInput;
    }

    public WebElement getBirthDayinput() {
        return birthDayinput;
    }

    public WebElement getCheckBoxEnglish() {
        return checkBoxEnglish;
    }

    public WebElement getCheckBoxSpanish() {
        return checkBoxSpanish;
    }

    public WebElement getCheckBoxFrench() {
        return checkBoxFrench;
    }

    public List<WebElement> getGenders() {
        return genders;
    }

    public WebElement getEmpStatsDD() {
        return empStatsDD;
    }

    public WebElement getAddBtnAfterForm() {
        return addBtnAfterForm;
    }

    public WebElement getCancelBtnAfterForm() {
        return cancelBtnAfterForm;
    }

    public WebElement getClearAllFieldsBtn() {
        return clearAllFieldsBtn;
    }

    public List<WebElement> getNameList() {
        return nameList;
    }

    public List<WebElement> getSurNameList() {
        return surNameList;
    }

    public WebElement getResetListBtn() {
        return resetListBtn;
    }
}
