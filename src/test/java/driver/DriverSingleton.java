package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver == null){

//            System.setProperty("browser", "chromeHeadless");

            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case "chromeHeadless": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driver = new ChromeDriver(options);
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().version("124.0.6367.201");
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
