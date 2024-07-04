package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import static config.constants.*;

public class GoogleSearchTest extends CommonConditions{

    @Test
    public void openGoogleSearchPage() throws InterruptedException {
        System.out.println("Browser: " + System.getProperty("browser"));

        driver.get(GOOGLE_SEARCH_PAGE);
        String actualTitle = driver.getTitle();

        Thread.sleep(1_000);

        Assert.assertEquals(GOOGLE_PAGE_TITLE, actualTitle);
    }

    @Test
    public void openGoogleSearchPageFail() throws InterruptedException {
        System.out.println("Browser: " + System.getProperty("browser"));

        driver.get(GOOGLE_SEARCH_PAGE);
        String actualTitle = driver.getTitle();

        Thread.sleep(1_000);

        Assert.assertEquals("GOOGLE_PAGE_TITLE", actualTitle);
    }

}
