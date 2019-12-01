package qacourses.lesson5;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.pageobgect.Pages.BaseTest;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class AbstractPage {

    private BaseTest basetest;

    @FindBy(xpath = "//a[@class='login']")
    WebElement SIGNIN_BTN;

    public AbstractPage(BaseTest basetest){
        this.basetest =  basetest;
        PageFactory.initElements(basetest.getDriver(), this);
        basetest.waitElementVisibility(SIGNIN_BTN);
    }







}
