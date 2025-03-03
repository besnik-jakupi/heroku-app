package utils;

import org.openqa.selenium.By;

public class Selectors {
    public static final By FILE_UPLOAD_INPUT = By.id("file-upload");
    public static final By SubmitButton = By.id("file-submit");
    public static final By ClickHereText = By.cssSelector(".example a");
    public static final By UPLOAD_SUCCESS_MESSAGE = By.xpath("//div[@class='example']/h3");

    public static By ButtonWithText(String text) {
        return By.xpath("//button[text()='"+text+"']");
    }

    public static By user(String text) {
        return By.xpath("(//div[@class='figure']/img)["+text+"]");
    }

    public static By userName(String text) {
        return By.xpath("(//div[@class='figure']/div[@class='figcaption']/h5)[" + text + "]");
    }

    public static By CheckBox(String text) {
        return By.xpath("//form[@id='checkboxes']/input[following-sibling::text()[contains(.,'" + text + "')]]");
    }
}