package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest
{
    /**
     * 1. This method will click on element
     */
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    /**
     * 2. This method will get text from element
     */
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    /**
     * 3. This method will send the text to
     */
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //4. From here --------->  All 3 Select Options method
    /**
     * 4.1 This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text)
    {
        WebElement dropdown= driver.findElement(by);
        Select select= new Select(dropdown);
        select.selectByVisibleText(text);
    }

    /**
     * 4.2 This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int indexNumber)
    {
        WebElement dropdown= driver.findElement(by);
        Select select=new Select(dropdown);
        select.selectByIndex(indexNumber);
    }

    /**
     * 4.3 This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String valueText)
    {
        new Select(driver.findElement(by)).selectByValue(valueText);
    }

    // 5 From here --------> All 5 alerts method starts
    /**
     * 5.1 Alerts method for switch to alert
     */
    public void switchToAlertOption(By by)
    {
        clickOnElement(by); // click on alert button
        driver.switchTo().alert(); // create alert object and switch to alert
    }

    /**
     * 5.2 Alert method for getting text
     */
    public void getAlertText(By by)
    {
        System.out.println("Alert text are : "+driver.switchTo().alert().getText());
    }

    /**
     * 5.3 Alert method for accepting alert
     */
    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    /**
     * 5.4 Alert method for dismiss/canceling alert
     */
    public void dismissAlert()
    {
        driver.switchTo().alert().dismiss();
    }

    /**
     * 5.5 Alert method for sending text to alert
     */
    public void sendTextToAlert(String alertText)
    {
        driver.switchTo().alert().sendKeys(alertText);
    }

    /**
     * 6.  Action ---> mouse hover
     */
    public void mouseHoverAction(By by, By by1)
    {
       WebElement text1= driver.findElement(by);
       WebElement text2= driver.findElement(by1);
       new Actions((driver)).moveToElement(text1).moveToElement(text2).click().build().perform();
    }

    /**
     * 7. Assert ---> to verify the text
     */
    public void assertVerifyText(String text, String expectedText, By by)
    {
        String actualText=getTextFromElement(by);
        Assert.assertEquals(text,expectedText,actualText);
    }
}
