package qacourses.lesson5;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;
import qa.pageobgect.Pages.HomePage;
import qa.pageobgect.Pages.LoginPage;


public class AbstractPage {

    protected private BaseTest basetest;

    @FindBy(xpath = "//a[@class='login']")
    WebElement SIGNIN_BTN;

    public AbstractPage(BaseTest basetest){
        this.basetest =  basetest;
        PageFactory.initElements(basetest.getDriver(), this);
        basetest.waitElementVisibility(SIGNIN_BTN);
    }

    public LoginPage clickSignin(){
        basetest.waitElementVisibility(SIGNIN_BTN);
        SIGNIN_BTN.click();
        return new LoginPage(basetest);

    }








}
