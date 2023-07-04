package Electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    @Test
    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        /**
         * Both steps in 1 mousehover action
         *  1.1 Mouse Hover on “Electronics”Tab
         *  1.2 Mouse Hover on “Cell phones” and click
         */
        mouseHoverAction(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"), By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        Thread.sleep(2000);

        //1.3 Verify the text “Cell phones”
        assertVerifyText("Cell phone text not verify","Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"));
        Thread.sleep(2000);
    }

    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException
    {
        /**
         * Both steps 2.1 and 2.2 in one step of mouse hover
         * 2.1 Mouse Hover on “Electronics”Tab
         * 2.2 Mouse Hover on “Cell phones” and click
         * */
        mouseHoverAction(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"), By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        Thread.sleep(2000);

        //2.3 Verify the text “Cell phones”
        assertVerifyText("Cell phone text not verify","Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"));
        Thread.sleep(2000);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(1000);

        //2.6 Verify the text “Nokia Lumia 1020”
        assertVerifyText("Nokia lumia text not found","Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));

        //2.7 Verify the price “$349.00”
        assertVerifyText("$349.00 text not found","$349.00",By.xpath("//span[@id='price-value-20']"));
        Thread.sleep(1000);

        //2.8 Change quantity to 2
        WebElement quantity= driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        quantity.clear();
        quantity.sendKeys("2");
        Thread.sleep(1000);

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        assertVerifyText("The Product message not found","The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAction(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        assertVerifyText("Shopping cart message not found","Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);

        //2.13 Verify the quantity is 2
        //assertVerifyText("Quantity is not 2", "2", By.xpath("//input[@class='qty-input']"));
        Thread.sleep(4000);

        //2.14 Verify the Total $698.00
        assertVerifyText("Text total not found", "$698.00", By.xpath("//span[@class='product-subtotal']"));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText("Welcome text not found","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Thread.sleep(1000);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));


        //2.19 Verify the text “Register”
        assertVerifyText("Register text not found","Register", By.xpath("//h1[contains(text(),'Register')]"));
        Thread.sleep(1000);

        //2.20 Fill the mandatory fields

        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Vishwa");

        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");

        sendTextToElement(By.xpath("//input[@id='Email']"),"va@gmail.com");

        sendTextToElement(By.xpath("//input[@id='Password']"),"v123456");

        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"v123456");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        assertVerifyText("Register complete text not found", "Your registration completed",By.xpath("//div[contains(text(),'Your registration completed')]"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping cart”
        assertVerifyText("Shopping cart text not found","Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
