package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    @FindBy(className = "btn btn-primary")
    WebElement logIn;
    @FindBy(id = "login-form")
    WebElement logInForm;
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage openPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        PageFactory.initElements(driver,LogInPage.this);
        return this;

    }

    public LogInPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auth-form")));
        return this;
    }
    public LogInPage LogIn(User user){
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        logInForm.submit();
        return this;
    }
}