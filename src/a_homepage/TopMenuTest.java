package a_homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = " http://tutorialsninja.com/demo/index.php?";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        mouseHoverAndClick(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));
        selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        assertAssert("Not Matching", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        mouseHoverAndClick(By.linkText("Laptops & Notebooks"));
        selectMenu("Show All Laptops & Notebooks");
        String expectedText = "Laptops & Notebooks";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        assertAssert("Not Matching", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        mouseHoverAndClick(By.linkText("Components"));
        selectMenu("Show All Components");
        String expectedText = "Components";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        assertAssert("Not Matching", expectedText, actualText);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        closeBrowser();
    }
}
