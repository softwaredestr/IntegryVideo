import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IntegryVideoChat {



        @Test
        public void ChatTest(){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
            ChromeDriver driver = new ChromeDriver();



            driver.manage().window().maximize();
            WebElement input = driver.findElement(By.className("integri-chat-input"));
            WebElement button = driver.findElement(By.cssSelector("button.integri-chat-send-message"));
            Actions chat = new Actions(driver);
            WebElement deleteButton = driver.findElement(By.cssSelector("span.integri-chat-remove-message"));



            chat.moveToElement(input).sendKeys("qreetfsdf").sendKeys(Keys.ENTER).build().perform();
            deleteButton.click();
            chat.moveToElement(input).sendKeys("hello").perform();
            chat.moveToElement(button).click().build().perform();


            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            chat.moveToElement(input).sendKeys("Praesent condimentum consequat mi, sit amet venenatis nisl maximus sit amet. Donec sem mi, sagittis nec fringilla quis, pretium eu dui. " +
                    "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam nisl felis, tincidunt nec volutpat non, maximus vitae urna. " +
                    "Sed mi lacus, commodo at semper vel, vestibulum sit amet sem. Duis a semper nibh. " +
                    "Mauris arcu purus, pulvinar id commodo vitae, aliquam at nibh. Cras rutrum ac nibh ut faucibus. " +
                    "In aliquam accumsan sapien, at dignissim elit maximus vel. Aliquam fringilla pellentesque leo at sagittis. " +
                    "Vivamus velit felis, fermentum in accumsan vel, cursus mattis lorem. Nunc congue tellus ligula. Vivamus sapien velit, rutrum ut hendrerit sed, gravida interdum purus. Nullam et nisl maximus, feugiat leo vel, pretium urna. Nam placerat urna a ipsum vestibulum ultrices." +
                    "Phasellus in dolor lorem. Nulla sodales vehicula vestibulum. Donec malesuada malesuada dolor. " +
                    "Phasellus tristique justo ac quam lacinia luctus. Nam volutpat.").sendKeys(Keys.ENTER).build().perform();

            chat.moveToElement(input).sendKeys("https://dev.integrivideo.com/demo/5e1dbe5301e3a863ed30f77c").sendKeys(Keys.ENTER).build().perform();
            chat.moveToElement(input).sendKeys("<html><body><p>test</p></body></html>").sendKeys(Keys.ENTER).build().perform();







    }
}
