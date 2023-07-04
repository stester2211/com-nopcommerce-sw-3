package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    //Write the following Test:
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException
    {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile'] //a[@href='/computers']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        Thread.sleep(2000);

        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> products= driver.findElements(By.xpath("//h2[@class='product-title']"));
        System.out.println("Products in desktop page list in descending order : ");
        for (WebElement productsInDescendingList : products)
        {
            System.out.println(productsInDescendingList.getText());
        }
        Thread.sleep(2000);
    }

    // 2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile'] //a[@href='/computers']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"),1);
        Thread.sleep(1000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='buttons']//button[text()='Add to cart']"));
        Thread.sleep(1000);

        //2.5 Verify the Text "Build your own computer"
        assertVerifyText("Build your computer text not found","Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "1");
        Thread.sleep(2000);

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);
        Thread.sleep(2000);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        //clickOnElement(By.id("product_attribute_5_10"));
        Thread.sleep(2000);
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);

        // 2.11 Verify the price "$1,475.00"
        assertVerifyText("Price $1475 not found ","$1,475.00",By.xpath("//span[@id='price-value-1']"));
        Thread.sleep(2000);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertVerifyText("Add to cart message not found","The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(2000);

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAction(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        assertVerifyText("Shopping cart message not found","Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@class, 'qty-input')]"));
        quantity.clear();
        quantity.sendKeys("2");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        assertVerifyText("Updated Price not found","$2,950.00",By.xpath("//span[@class='product-subtotal']"));
        Thread.sleep(2000);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(2000);

        //2.20 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText("Welcome text not found", "Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Thread.sleep(2000);

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Vishwa");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"vpatel5@gmail.com");

        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"153");

        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"23");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Windsor");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Asking");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"123456");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"1234567895");
        Thread.sleep(2000);

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']//button[text()='Continue']"));
        Thread.sleep(2000);

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[text()='Continue']"));
        Thread.sleep(2000);

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']//button[text()='Continue']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"aavv");

        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"1111222233334444");

        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),1);

        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"),1);

        sendTextToElement(By.xpath("//input[@id='CardCode']"),"123");
        Thread.sleep(1000);

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']//button[text()='Continue']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        assertVerifyText("Credit card text not found","Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        Thread.sleep(2000);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        assertVerifyText("Shipping text not found", "Next Day Air",By.xpath("//li[@class='shipping-method']//span[@class='value']"));
        Thread.sleep(1000);

        //2.33 Verify Total is “$2,950.00”
        assertVerifyText("Price text is not verify", "$2,950.00", By.xpath("//span[@class='product-subtotal']"));

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(1000);

        //2.35 Verify the Text “Thank You”
        assertVerifyText("Thank you text not verify","Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));

        //2.36 Verify the message “Your order has been successfully processed!”
        assertVerifyText("Your order successfully text not found","Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(1000);

        //2.37 Verify the text “Welcome to our store”
        assertVerifyText("Welcome text not found","Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
