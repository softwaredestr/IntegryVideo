package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {
    @Test
    public void LogInForm(){
        User user = new User("qwerty@mailinator.com", "12345678");
        new LogInPage(driver)
                .openPage()
                .LogIn(user);
    }
}
