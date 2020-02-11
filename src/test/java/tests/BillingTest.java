package tests;

import Utils.AllureUtils;
import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import pages.BillingPage;
import pages.LogInPage;

public class BillingTest extends BaseTest {

    @Test(description = "Add cards and paypal click")
    @Description("Добавление карт и нажатие на кнопку")
    public void addCards(){
        User user = new User("qwerty@mailinator.com", "12345678");
        new LogInPage(driver)
                .openPage()
                .LogIn(user);
        new BillingPage(driver)
            .openPage()
            .addNewCard()
            .isPageOpened()
            .fillFields("4242424242424242", "02", "2024", "Name Name")
            .addClick()
            .openPage()
            .verifyAddedCards(1)
            .addNewCard()
            .payPalClick();
        AllureUtils.takeScreenshot(driver);
    }
}
