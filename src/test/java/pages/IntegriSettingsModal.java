package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class IntegriSettingsModal extends BasePage {

    private By settingButton = By.cssSelector(".integri-chat-settings");
    private By settingModal = By.className("integri-user-settings");
    private By username = By.name("userName");
    private By email = By.name("userEmail");
    private By photoURL = By.name("userPic");
    private By saveButton = By.cssSelector(".integri-user-settings-save");
    private By cancelButton = By.cssSelector(".integri-user-settings-reset");
    private By crossButton = By.xpath("//*[contains(text(),'Settings')]//*[contains(@class,'close-integri-modal')]");

    public IntegriSettingsModal(WebDriver driver) {
        super(driver);
    }
    @Step("Open settings")
    public void openSettingsModal(){
        driver.findElement(settingButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingModal));
    }
    @Step("Edit username")
    public void editUsername(String editText){
        driver.findElement(username).click();
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(editText);
        driver.findElement(username).sendKeys(Keys.ENTER);
    }
    @Step("Edit email")
    public void editEmail(String editText){
        driver.findElement(email).click();
        driver.findElement(email).sendKeys(editText);
        driver.findElement(email).click();
    }
    @Step("Edit photo URL")
    public void editPhoto(String editText){
        driver.findElement(photoURL).click();
        driver.findElement(photoURL).sendKeys(editText);
        driver.findElement(photoURL).sendKeys(Keys.ENTER);
    }
    @Step("Verify username")
    public void verifyUsername(String expectedUsername){
        String actualUsername = driver.findElement(username).getAttribute("value");
        Assert.assertEquals(actualUsername, expectedUsername );

    }
    @Step("Verify email")
    public void verifyEmail(String expectedEmail){
        String actualEmail = driver.findElement(email).getAttribute("value");
        Assert.assertEquals(actualEmail, expectedEmail);
    }
    @Step("Verify photo URL")
    public void verifyPhotoURL(String expectedPhotoURL){
        String actualPhotoURL = driver.findElement(photoURL).getAttribute("value");
        Assert.assertEquals(actualPhotoURL, expectedPhotoURL);
    }
    @Step("Click save button")
    public void save(){
        driver.findElement(saveButton).click();
    }
    @Step("Click cancel button")
    public void cancel(){
        driver.findElement(cancelButton).click();
    }
    @Step("Click cross")
    public void crossClick(){
        driver.findElement(crossButton).click();
        Assert.assertTrue(!driver.findElement(crossButton).isDisplayed());
    }




    //username
    //email
    //photo
    //save button
    //cancel button
    //
}
