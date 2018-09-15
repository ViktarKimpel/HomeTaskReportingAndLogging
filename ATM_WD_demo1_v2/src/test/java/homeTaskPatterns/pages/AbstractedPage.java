package homeTaskPatterns.pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.MyLogger;

import java.io.File;
import java.io.IOException;


public class AbstractedPage {
        protected WebDriver driver;
        private static final int WAIT_FOR_ELEMENT_SECONDS = 15;
        protected static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

        public AbstractedPage (WebDriver driver){
            this.driver= driver;
        }

        protected void waitForElementVisible (By locator){
            new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS ).until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        }

        protected void highLightElement (By locator){
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3000px black'", driver.findElement(locator));
        }
        protected void unHighlightElement (By locator){
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
        }
        protected void clickByJS (By locator){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(locator));
        }

        protected void takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            MyLogger.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            MyLogger.error("Failed to make screenshot");
        }
    }
    }

