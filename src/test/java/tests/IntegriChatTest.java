package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

public class IntegriChatTest extends BaseTest {
    IntegriChatPage chat;
    @Test
    public void validateMessageSending(){
        String message = "Blabla";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageUsingButton();
        chat.messageShouldContainText(message, 1);

        chat.typeMessage("blalala");
        chat.sendMessageUsingButton();
        chat.messageShouldContainText("blalala", 2);
        //input
        //send
        //validate
    }
}
