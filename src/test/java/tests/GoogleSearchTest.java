package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import static config.constants.*;

public class GoogleSearchTest extends CommonConditions{

    @Test
    public void openGoogleSearchPage() {
        System.out.println("Browser: " + System.getProperty("browser"));

        driver.get(GOOGLE_SEARCH_PAGE);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(GOOGLE_PAGE_TITLE, actualTitle);
    }

    @Test
    public void openGoogleSearchPageFail() {
        System.out.println("Browser: " + System.getProperty("browser"));

        driver.get(GOOGLE_SEARCH_PAGE);
        String actualTitle = driver.getTitle();

        Assert.assertEquals("GOOGLE_PAGE_TITLE", actualTitle);
    }

}
