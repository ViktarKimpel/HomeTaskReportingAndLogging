package homeTaskPatterns.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reporting.MyLogger;


public class StartPage extends AbstractedPage {

    private static final String URL = "https://www.google.com/gmail/about/#";
    private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']");

        public StartPage (WebDriver driver)
        {
            super(driver);
        }

        public void openGmail()
        {
            MyLogger.info("Going to URL: " + URL);
            driver.get(URL);
        }

    public LogInPage signIn (){
        waitForElementVisible(SIGN_IN_BUTTON_LOCATOR);
        MyLogger.info("Sign In button is displayed");
        takeScreenshot();
        driver.findElement (SIGN_IN_BUTTON_LOCATOR).click();
        return new LogInPage(driver);


    }
    }
