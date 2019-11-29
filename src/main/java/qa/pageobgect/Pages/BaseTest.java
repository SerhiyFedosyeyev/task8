package qa.pageobgect.Pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private  WebDriverWait wait;

    public BaseTest(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();
        //Explicit Wait
        wait = new WebDriverWait(driver, 10);

    }

    public void closeSite(){
     driver.quit();
    }


    public WebDriver getDriver(){
        this.driver = driver;
        return driver;
    }
}
