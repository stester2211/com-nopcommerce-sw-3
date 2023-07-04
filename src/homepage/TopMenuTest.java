package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

// 1. create class "TopMenuTest"
public class TopMenuTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu)
    {
        //1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.linkText(menu));
    }

    //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() throws InterruptedException
    {
        selectMenu("Electronics");
        String expectedText="https://demo.nopcommerce.com/electronics";
        String actualText=driver.getCurrentUrl();
        Assert.assertEquals("Page is not navigated and wont find the electronics text",expectedText,actualText);
        Thread.sleep(2000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
