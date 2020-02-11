package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BillingPage extends BasePage {
    By creditCardForm = By.id("credit-card");
    By addNewBtn = By.xpath("//*[contains(text(),'Add new')]");
    By cardInput = By.className("form-control");
    By addBtn = By.xpath("//button[@class='btn']");
    By addedCards = By.className("cards");
    By message = By.className("message");
    By payPal = By.xpath("//iframe[@class='zoid-component-frame zoid-visible']");


    public BillingPage(WebDriver driver) {
        super(driver);
    }
    public BillingPage openPage(){
        driver.get("https://dev.integrivideo.com/app/billing");
        return this;
    }
    public BillingPage addNewCard(){
        driver.findElement(addNewBtn).click();
        return this;
    }
    public BillingPage addClick(){
        driver.findElement(addBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addBtn)));
        return this;
    }
    public BillingPage isPageOpened(){
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(creditCardForm)));
        } catch(TimeoutException ex) {
            throw new TimeoutException("Страница не загрузилась");
        }
        return this;
    }
    public BillingPage fillFields(String cardNum, String month,String year, String name){
        driver.findElements(cardInput).get(0).click();
        driver.findElements(cardInput).get(0).sendKeys(cardNum);
        driver.findElements(cardInput).get(1).click();
        driver.findElements(cardInput).get(1).sendKeys(month);
        driver.findElements(cardInput).get(2).sendKeys(year);
        driver.findElements(cardInput).get(3).sendKeys(name);
        return this;
    }
    public BillingPage verifyAddedCards(int expectedCount){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("cards"))));
        Assert.assertEquals(driver.findElements(addedCards).size(), expectedCount);
        return this;
    }
    public BillingPage payPalClick(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(payPal)));
        driver.findElement(payPal).click();
        return this;
    }



}
