package c_laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

//        1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

//        1.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

//        1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

//        1.4 Verify the Product price will arrange in High to Low order.
        String expTextHighLow = "Price (High > Low)";
        String actTextHighLow = getTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        assertAssert("Not in correct order", expTextHighLow, actTextHighLow);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

//        2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

//        2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

//        2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[1]/a[1]/img[1]"));

//        2.5 Verify the text “MacBook”
        String expTextMac = "MacBook";
        String actTextMac = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        assertAssert("Not correct product", expTextMac, actTextMac);

//        2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expMessageCart = "Success: You have added MacBook to your shopping cart!";
        String actMessageCart = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 54);
        assertAssert("Not in Cart", expMessageCart, actMessageCart);

//        2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

//        2.9 Verify the text "Shopping Cart"
        String expTextShopCart = "Shopping Cart";
        String actTextShopCart = getTextFromElement(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13);
        assertAssert("Not correct text", expTextShopCart, actTextShopCart);

//        2.10 Verify the Product name "MacBook"
        Thread.sleep(2000);
        String expTextPordMac = "MacBook";
        String actTextPordMac = getTextFromElement(By.xpath("(//a[text()='MacBook'])[2]"));
        System.out.println(actTextMac);
        assertAssert("Not correct text", expTextPordMac, actTextPordMac);

//        2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");

//        2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

//        2.13 Verify the message “Success: You have modified your shopping cart!”
        String expMessageCartModified = "Success: You have modified your shopping cart!";
        System.out.println(expMessageCartModified.length());
        String actMessageCartModified = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 46);
        System.out.println(actMessageCartModified);
        assertAssert("Not Updated", expMessageCartModified, actMessageCartModified);

//        2.14 Verify the Total £737.45
        clickOnElement(By.xpath("//form[@id='form-currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
        String expTotal = "£737.45";
        String actTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        System.out.println(actTotal);
        assertAssert("Not correct total", expTotal, actTotal);

//        2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

//        2.16 Verify the text “Checkout”
        String expTextVerify = "Checkout";
        String actTextVerify = getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        assertAssert("Not correct total", expTextVerify, actTextVerify);

//        2.17 Verify the Text “New Customer”
        String expTextNewCustomer = "New Customer";
        Thread.sleep(2000);
        String actTextNewCustomer = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        System.out.println(actTextNewCustomer);
        assertAssert("Not correct total", expTextNewCustomer, actTextNewCustomer);

//        2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

//        2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

//        2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "Prime.Testing567@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "02034568927");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "11 Tokayo Road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "SE26 5QF");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-country']"), "222");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "3553");

//        2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

//        2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please call on arrival");

//        2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));

//        2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

//        2.25 Verify the message “Warning: Payment method required!"
        String expMessageWarning = "Warning: Payment method required";
        System.out.println(expMessageWarning.length());
        String actMessageWarning = getTextFromElement(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).substring(0,32);
        assertAssert("Not correct total", expMessageWarning, actMessageWarning);
    }


}
