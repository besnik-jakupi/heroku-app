package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.io.File;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    public void clickElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void uploadFile(By fileInputLocator, String fileName) {
        WebElement fileInput = driver.findElement(fileInputLocator);
        File file = new File("src/test/resources/test-files/"+fileName);
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void dragAndDrop(String firstElement, String secondElement){
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id(firstElement));
        WebElement target = driver.findElement(By.id(secondElement));
        actions.dragAndDrop(source, target).perform();
    }

    public void verifyElementIsDisplayed(By locator, String message) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(message, element.isDisplayed());
    }

    public void verifyTextOnAlert(String text) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Alert text does not match", text, alertText);
    }
    public void verifyTextOfColumn(String expected, String column) {
        WebElement element = driver.findElement(By.xpath("//div[@id='column-"+column+"']/*"));
        String actualText = element.getText();
        Assert.assertEquals("Text does not match", expected, actualText);
    }

    public void hoverOverElement(By selector) {
        WebElement elementToHover = driver.findElement(selector);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    public void validateHoveredText(By textSelector, String expectedText) {
        WebElement nameText = driver.findElement(textSelector);
        Assert.assertTrue("User name text is not displayed!", nameText.isDisplayed());
        Assert.assertEquals("User name does not match!", "name: user"+expectedText, nameText.getText());
    }

    public void checkCheckbox(By checkboxSelector) {
         WebElement checkbox = driver.findElement(checkboxSelector);
        if (!checkbox.isSelected()) {
            try {
                checkbox.click();
            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", checkbox);
            }
        }
    }

    public void verifyCheckboxIsChecked(By checkboxSelector) {
        WebElement checkbox = driver.findElement(checkboxSelector);

        String checkboxCheckedAttribute = checkbox.getAttribute("checked");
        boolean isSelected = checkbox.isSelected();

        Assert.assertTrue("The checkbox is NOT checked!", (checkboxCheckedAttribute != null || isSelected));
    }

    public void verifyUserCanSeeExpectedUrl(String expected){
        String originalWindow = driver.getWindowHandle();
        int retries = 0;
        while (driver.getWindowHandles().size() == 1 && retries < 10) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retries++;
        }

        Set<String> windowHandles = driver.getWindowHandles();

        if (windowHandles.size() > 1) {
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Switched to new tab: " + driver.getTitle());
                    break;
                }
            }
            String newTabUrl = driver.getCurrentUrl();
            System.out.println("New Tab URL: " + newTabUrl);
            Assert.assertTrue("New tab URL does not contain expected text!", newTabUrl.contains(expected));
        } else {
            Assert.fail("New tab was not opened!");
        }
    }
}