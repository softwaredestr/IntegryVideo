package pages;

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

    public void openPage(){
        driver.get(URL);
    }

    public void typeMessage(String message){
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
    }
    public void sendMessageUsingButton(){
        driver.findElement(SEND_BUTTON).click();
    }
    public void sendMessageUsingEnter(){
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(Keys.ENTER);
    }
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
    public void verifyTrialMessage(){
        String trial = "This is trial version";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TRIAL_MESSAGE_SCREEN)));
        String actualTrial = driver.findElement(TRIAL_MESSAGE_SCREEN).getText();
        Assert.assertTrue(actualTrial.contains(trial));

    }
    public void editMessage(String editedText){
        driver.findElement(EDIT_BUTTON).click();
        driver.findElement(EDIT_AREA).click();
        driver.findElement(EDIT_AREA).clear();
        driver.findElement(EDIT_AREA).sendKeys(editedText);
        driver.findElement(EDIT_AREA).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBe(MESSAGE_TEXT, editedText));


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
