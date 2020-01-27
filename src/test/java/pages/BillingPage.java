package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingPage extends BasePage {
    By billingForm = By.className("container-fluid");
    By addNewBtn = By.className("btn");
    By cardInput = By.className("form-control");
    By addBtn = By.className("btn");
    By addedCards = By.className("cards");
    By message = By.className("message");
    By payPal = By.

    public BillingPage(WebDriver driver) {
        super(driver);
    }
}
