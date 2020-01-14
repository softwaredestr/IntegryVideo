import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Settings {
    public static final String URL = "https://dev.integrivideo.com/demo/5e1c2564ada85052a99d079d";
    @Test
    public void chatTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.manage().window().maximize();
        WebElement input = driver.findElement(By.className("integri-chat-input"));
        WebElement button = driver.findElement(By.cssSelector("button.integri-chat-send-message"));
        Actions chat = new Actions(driver);

        chat.moveToElement(input).sendKeys("Praesent condimentum consequat mi, sit amet venenatis nisl maximus sit amet. Donec sem mi, sagittis nec fringilla quis, pretium eu dui. " +
                "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam nisl felis, tincidunt nec volutpat non, maximus vitae urna. " +
                "Sed mi lacus, commodo at semper vel, vestibulum sit amet sem. Duis a semper nibh. " +
                "Mauris arcu purus, pulvinar id commodo vitae, aliquam at nibh. Cras rutrum ac nibh ut faucibus. " +
                "In aliquam accumsan sapien, at dignissim elit maximus vel. Aliquam fringilla pellentesque leo at sagittis. " +
                "Vivamus velit felis, fermentum in accumsan vel, cursus mattis lorem. Nunc congue tellus ligula. Vivamus sapien velit, rutrum ut hendrerit sed, gravida interdum purus. Nullam et nisl maximus, feugiat leo vel, pretium urna. Nam placerat urna a ipsum vestibulum ultrices." +
                "Phasellus in dolor lorem. Nulla sodales vehicula vestibulum. Donec malesuada malesuada dolor. " +
                "Phasellus tristique justo ac quam lacinia luctus. Nam volutpat.").sendKeys(Keys.ENTER).build().perform();


        driver.navigate().refresh();




    }
}
