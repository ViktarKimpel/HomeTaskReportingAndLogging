package homeTaskPatterns.pages;

import homeTaskPatterns.businessObjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reporting.MyLogger;


public class GmailPasswordPage extends AbstractedPage {

    private static final By GMAIL_PASSWORD_INPUT_LOCATOR = By.xpath("//div[@class='Xb9hP']/input[@type='password']");
    private static final By NEXT_BUTTON_LOCATOR = By.cssSelector("#passwordNext");


    public GmailPasswordPage (WebDriver driver)
    {
        super(driver);
    }

    public GmailPasswordPage fillGmailPasswordInput (User user){
        waitForElementVisible(GMAIL_PASSWORD_INPUT_LOCATOR);
        MyLogger.info("Entering of password");
        WebElement input = driver.findElement(GMAIL_PASSWORD_INPUT_LOCATOR);
        input.sendKeys(user.getPassword());
        return this;
    }
    public GmailMainPage pressNextButton (){
        waitForElementVisible(NEXT_BUTTON_LOCATOR);
        MyLogger.info("Press next button");
        driver.findElement (NEXT_BUTTON_LOCATOR).click();
        takeScreenshot();
        return new GmailMainPage(driver);
    }





}
