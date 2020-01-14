package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.AssertJUnit.assertEquals;

public class IntegriChatPage extends BasePage {
   private By MESSAGE_TEXT_AREA = By.tagName("textarea");
   private By SEND_BUTTON = By.xpath("//button[@title='Send message']");
   private By MESSAGE_TEXT = By.cssSelector(".integri-chat-message-text");
   private  By EDIT_BUTTON = By.xpath("");
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

        /**
         *
         * @param message - message to be written
         * @param messageNumber - starts from 1
         */
        public void messageShouldContainText(String message, int messageNumber){
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_TEXT, messageNumber - 1));
       String text = driver.findElements(MESSAGE_TEXT).get(messageNumber - 1).getText();
       assertEquals(message, text, "Message text is not correct");
    }
}
