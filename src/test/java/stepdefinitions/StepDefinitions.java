package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.Selectors;


public class StepDefinitions extends BasePage {

    private WebDriver driver = DriverManager.getDriver();
    @Given("User is on {string} page")
    public void userIsOnUploadPage(String url) {
        driver.get(ConfigReader.getProperty("base.url")+url);
    }
    @When("user uploads file {string}")
    public void iUploadTheFile(String fileName) {
        uploadFile(Selectors.FILE_UPLOAD_INPUT, fileName);
        clickElement(Selectors.SubmitButton);
    }

    @Given("user drags {string} element to element {string} position")
    public void userDragsElementToElementPosition(String string, String string2) {
        dragAndDrop(string, string2);
    }

    @Then("user verifies column {string} is in second position")
    public void userVerifiesColumnIsAfterColumnPosition(String column){
        verifyTextOfColumn("B", column.toLowerCase());
    }

    @When("user clicks button with text {string}")
    public void userClicksButtonWithText(String text){
        clickElement(Selectors.ButtonWithText(text));
    }

    @And("user clicks Click here text to open new window")
    public void userClicksClickHereTextToOpenNewWindow(){
        clickElement(Selectors.ClickHereText);
    }

    @And("user hovers with mouse on {string} user")
    public void userHoversWithMouseOnUser(String user){
        hoverOverElement(Selectors.user(user));
    }
    @And("user can see name user {string} properly displayed")
    public void userCanSeeNameUserProperlyDisplayed(String user){
        validateHoveredText(Selectors.userName(user), user);
    }
    @And("user checks the {string}")
    public void userChecksThe(String checkbox){
        checkCheckbox(Selectors.CheckBox(checkbox));
    }

    @And("the {string} should be checked")
    public void theShouldBeChecked(String checkbox){
        verifyCheckboxIsChecked(Selectors.CheckBox(checkbox));
    }

    @Then("user verifies the file is uploaded successfully")
    public void iVerifyTheFileIsUploadedSuccessfully() {
        verifyElementIsDisplayed(Selectors.UPLOAD_SUCCESS_MESSAGE, "File Uploaded!");
    }

    @Then("user can see text {string} on alert")
    public void userCanSeeTextOnAlert(String text) {
        verifyTextOnAlert(text);
    }

    @Then("user verifies the {string} opened window")
    public void userVerifiesTheOpenedWindow(String text) {
        verifyUserCanSeeExpectedUrl(text);
    }
}
