package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;
import pages.IntegriSettingsModal;
import pages.IntegryFileUploadPage;

public class IntegriChatTest extends BaseTest {
    IntegriChatPage chat;
    IntegriSettingsModal setting;
    IntegryFileUploadPage upload;
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

        chat.typeMessage("qwertyui");
        chat.sendMessageUsingEnter();
        chat.messageShouldContainText("qwertyui", 3);

        chat.typeMessage("https://dima-super-qa.jimdofree.com/");
        chat.sendMessageUsingEnter();
        chat.messageShouldContainText("https://dima-super-qa.jimdofree.com/", 4);

        chat.typeMessage("Praesent condimentum consequat mi, sit amet venenatis nisl maximus sit amet. Donec sem mi, sagittis nec fringilla quis, pretium eu dui." +
                "                    Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam nisl felis, tincidunt nec volutpat non, maximus vitae urna." +
                "                    Sed mi lacus, commodo at semper vel, vestibulum sit amet sem. Duis a semper nibh." +
                "                    Mauris arcu purus, pulvinar id commodo vitae, aliquam at nibh. Cras rutrum ac nibh ut faucibus." +
                "                    In aliquam accumsan sapien, at dignissim elit maximus vel. Aliquam fringilla pellentesque leo at sagittis." +
                "                    Vivamus velit felis, fermentum in accumsan vel, cursus mattis lorem. Nunc congue tellus ligula. Vivamus sapien velit, rutrum ut hendrerit sed, gravida interdum purus. Nullam et nisl maximus, feugiat leo vel, pretium urna. Nam placerat urna a ipsum vestibulum ultrices." +
                "                    Phasellus in dolor lorem. Nulla sodales vehicula vestibulum. Donec malesuada malesuada dolor." +
                "                    Phasellus tristique justo ac quam lacinia luctus. Nam volutpat.");
        chat.sendMessageUsingEnter();
        chat.messageShouldContainText("Praesent condimentum consequat mi, sit amet venenatis nisl maximus sit amet. Donec sem mi, sagittis nec fringilla quis, pretium eu dui." +
                "                    Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam nisl felis, tincidunt nec volutpat non, maximus vitae urna." +
                "                    Sed mi lacus, commodo at semper vel, vestibulum sit amet sem. Duis a semper nibh." +
                "                    Mauris arcu purus, pulvinar id commodo vitae, aliquam at nibh. Cras rutrum ac nibh ut faucibus." +
                "                    In aliquam accumsan sapien, at dignissim elit maximus vel. Aliquam fringilla pellentesque leo at sagittis." +
                "                    Vivamus velit felis, fermentum in accumsan vel, cursus mattis lorem. Nunc congue tellus ligula. Vivamus sapien velit, rutrum ut hendrerit sed, gravida interdum purus. Nullam et nisl maximus, feugiat leo vel, pretium urna. Nam placerat urna a ipsum vestibulum ultrices." +
                "                    Phasellus in dolor lorem. Nulla sodales vehicula vestibulum. Donec malesuada malesuada dolor." +
                "                    Phasellus tristique justo ac quam lacinia luctus. Nam volutpat.", 5);

        chat.typeMessage("<html><body><p>test</p></body></html>");
        chat.sendMessageUsingEnter();
        chat.messageShouldContainText("test", 6);

        chat.openPage();
        chat.sendMultipleMessage(11, "asdf");
        chat.verifyTrialMessage();



    }
                @Test
    public void editDeleteMessage(){
        chat = new IntegriChatPage(driver);
                    chat.openPage();
                    chat.typeMessage("1234");
                    chat.sendMessageUsingEnter();
                    chat.editMessage("qwer");
                    chat.messageShouldContainText("qwer", 1);
                    chat.deleteMessage();
                    chat.typeMessage("error");
                    chat.sendMessageUsingEnter();
                    chat.messageShouldContainText("error", 2);
                    chat.verifyErrorMessage("error");
    }
                @Test
    public void scriptAndInvite(){
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.inviteClick();
        chat.scriptCodeClick();
    }
                @Test
    public void SettingsModal(){
        chat = new IntegriChatPage(driver);
        setting = new IntegriSettingsModal(driver);

        chat.openPage();
        setting.openSettingsModal();
        setting.editUsername("Evgeny");
        setting.editEmail("eugeny.noskov@gmail.com");
        setting.editPhoto("12314534gfgdsgsdf");
        setting.verifyUsername("Evgeny");
        setting.verifyEmail("eugeny.noskov@gmail.com");
        setting.verifyPhotoURL("12314534gfgdsgsdf");
        setting.save();
        setting.openSettingsModal();
        setting.cancel();
        setting.openSettingsModal();
        setting.crossClick();

    }
        @Test
    public void FileUpload(){
        chat = new IntegriChatPage(driver);
        upload = new IntegryFileUploadPage(driver);
        chat.openPage();
        upload.openUploadModal();
        upload.FileUpload("/Users/ithub/Downloads/some-file.txt");
        upload.startUpload();
        upload.verifyAddedFile("some-file.txt");
        upload.openUploadModal();
        upload.FileUpload("/Users/ithub/Downloads/some-file.txt");
        upload.FileUpload("/Users/ithub/Downloads/some-file.txt");
        upload.startUpload();
        upload.verifyMultipleAdd(3);



        }
}
