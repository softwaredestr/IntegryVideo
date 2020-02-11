package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class IntegriChatPage extends BasePage {
   private By MESSAGE_TEXT_AREA = By.tagName("textarea");
   private By SEND_BUTTON = By.xpath("//button[@title='Send message']");
   private By MESSAGE_TEXT = By.cssSelector(".integri-chat-message-text");
   private By TRIAL_MESSAGE_SCREEN = By.xpath("//div[@class='sign-up']/..");
   private By EDIT_BUTTON = By.cssSelector(".integri-chat-edit-message");
   private By EDIT_AREA = By.tagName("textarea");
   private By DELETE_BUTTON = By.cssSelector(".integri-chat-remove-message");
   private By ERROR_MESSAGE = By.cssSelector(".integri-notify-error");
   private By INVITE_BUTTON = By.id("invite-users-to-chat");
   private By SCRIPT_CODE = By.className("component-code");
    public static final String URL = "https://dev.integrivideo.com/demo/chat/new";

    //input
    //send button
    //EditButton
    //DeleteButton
    //Copy code button
    //invite button
    //settings
    //profile details
    public IntegriChatPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open chat page")
    public void openPage(){
        driver.get(URL);
    }
    @Step("Type message")
    public void typeMessage(String message){
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
    }
    @Step("Send message using button")
    public void sendMessageUsingButton(){
        driver.findElement(SEND_BUTTON).click();
    }
    @Step("Send message using enter")
    public void sendMessageUsingEnter(){
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(Keys.ENTER);
    }
    @Step("Send multiple message")
    public void sendMultipleMessage(int messagesCount, String text){
        for (int i = 1; i <= messagesCount; i++){
                typeMessage(text);
                sendMessageUsingEnter();
            if (i == 11){
                break;
            }
            wait.until(ExpectedConditions.numberOfElementsToBe(MESSAGE_TEXT, i));
        }
    }
    @Step("Verify trial message")
    public void verifyTrialMessage(){
        String trial = "This is trial version";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TRIAL_MESSAGE_SCREEN)));
        String actualTrial = driver.findElement(TRIAL_MESSAGE_SCREEN).getText();
        Assert.assertTrue(actualTrial.contains(trial));

    }
    @Step("Edit message")
    public void editMessage(String editedText){
        driver.findElement(EDIT_BUTTON).click();
        driver.findElement(EDIT_AREA).click();
        driver.findElement(EDIT_AREA).clear();
        driver.findElement(EDIT_AREA).sendKeys(editedText);
        driver.findElement(EDIT_AREA).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBe(MESSAGE_TEXT, editedText ));


    }
    @Step("Delete message")
    public void deleteMessage(){
        driver.findElement(DELETE_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.textToBe(MESSAGE_TEXT, "removed..."));
    }
    @Step("Verify error message")
    public void verifyErrorMessage(String editedText){
        driver.findElement(EDIT_BUTTON).click();
        driver.findElement(EDIT_AREA).click();
        driver.findElement(EDIT_AREA).clear();
        driver.findElement(EDIT_AREA).sendKeys(editedText);
        driver.findElement(EDIT_AREA).clear();
        driver.findElement(EDIT_AREA).sendKeys(Keys.ENTER);
        String error = "Message cannot be empty!";
        wait.until(ExpectedConditions.textToBe(ERROR_MESSAGE, error));
        String actualError = driver.findElement(ERROR_MESSAGE).getText();
        Assert.assertEquals(actualError, error);
    }
    @Step("Invite click")
    public void inviteClick(){
        driver.findElement(INVITE_BUTTON).click();
    }
    @Step("Script code click")
    public void scriptCodeClick(){
        driver.findElement(SCRIPT_CODE).click();
    }




        /**
         *
         * @param message - message to be written
         * @param messageNumber - starts from 1
         */
        public void messageShouldContainText(String message, int messageNumber){
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, messageNumber - 1));
       String text = driver.findElements(MESSAGE_TEXT).get(messageNumber - 1).getText();
       assertEquals(message, text);
    }
}
