package qa.pageobgect.Pages;

import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends qacourses.lesson5.AbstractPage {
    private final String enterEmail="ff";
    private final String enterPassword="pass";
    @FindBy(xpath = "//form[@id='login_form']//input[@data-validate='isEmail']")
    WebElement mail;

    @FindBy(xpath = "//form[@id='login_form']//input[@id='passwd']")
    WebElement password;

    public LoginPage(BaseTest basetest) {
        super(basetest);
        basetest.waitElementVisibility(mail);
        basetest.waitElementVisibility(password);
        }


    public void setMail() {
        mail.sendKeys(enterEmail);
    }
    public void setPassword(){
        password.sendKeys(enterPassword);

    }

}
