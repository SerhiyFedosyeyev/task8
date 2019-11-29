package qacourses.lesson5;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String USERNAME = "//div[@id='divUsername']/input";
    private final String PASSWORD = "//input[@id='txtPassword']";
    public final String SUBMITBUTTON = "//input[@id='btnLogin']";
    public final String ERR_MESSAGE = "//span[@id='spanMessage']";
    public final String URL = "https://s1.demo.opensourcecms.com/s/44";
    private final String CLOSE_FRAME = "//i[@class='e-icon -icon-cancel']";


    /**
     * Setting up browser
     */
    @Before
    public void setUp() {
        // If you want to disable infobars please use this code
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

    /**
     * Log In with Invalid credentials
     */
    @Test
    public void invalidCredentials() {
        driver.get(URL);
        driver.switchTo().frame("preview-frame");
        driver.findElement(By.xpath(USERNAME)).sendKeys("User1");
        driver.findElement(By.xpath(PASSWORD)).sendKeys("Passw");
        driver.findElement(By.xpath(SUBMITBUTTON)).click();
        Assert.assertEquals("Wrong error message", "Invalid credentials", driver.findElement(By.xpath(ERR_MESSAGE)).getText());
    }

    /**
     * Log In with empty Username
     */
    @Test
    public void emptyUserName() {
        driver.get(URL);
        driver.switchTo().frame("preview-frame");
        driver.findElement(By.xpath(USERNAME)).sendKeys("");
        driver.findElement(By.xpath(PASSWORD)).sendKeys("");
        driver.findElement(By.xpath(SUBMITBUTTON)).click();
        Assert.assertEquals("Wrong error message", "Username cannot be empty", driver.findElement(By.xpath(ERR_MESSAGE)).getText());
    }

    /**
     * Log In with empty Password
     */
    @Test
    public void emptyPassword() {
        driver.get(URL);
        driver.switchTo().frame("preview-frame");
        driver.findElement(By.xpath(USERNAME)).sendKeys("name");
        driver.findElement(By.xpath(PASSWORD)).sendKeys("");
        driver.findElement(By.xpath(SUBMITBUTTON)).click();
        Assert.assertEquals("Wrong error message", "Password cannot be empty", driver.findElement(By.xpath(ERR_MESSAGE)).getText());

    }

    /**
     * Closing Header Frame
     */
    @Test
    public void closeFrame() {

        driver.get(URL);
        driver.findElement(By.xpath(CLOSE_FRAME));
        WebElement HEADFR = driver.findElement(By.xpath("//iframe[@title='AddThis utility frame']"));
        wait.until(ExpectedConditions.invisibilityOf(HEADFR));

    }

    /**
     * Close browser  window
     */
    @After
    public void tearDown() {
        driver.quit();
    }

}
