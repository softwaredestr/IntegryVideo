package tests;

import models.User;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {
    @Test
    public void SignUp(){
        User user = new User("qwerty@mailinator.com", "12345678");
        new SignUpPage(driver)
                .openPage()
                .signUp(user);

    }
}
