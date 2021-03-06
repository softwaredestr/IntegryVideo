package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class IntegryFileUploadPage extends BasePage {
        private By DnDButton = By.cssSelector(".integri-chat-manual-upload");
        private By uploadModal = By.className("integri-file-upload");
        private By uploadButton = By.xpath("//input[@class='integri-hide']");
        private By startButton = By.cssSelector(".integri-file-upload-start");
        private By addedFile = By.cssSelector(".integri-file-item-name");
        private By loader = By.xpath("//*[contains(text(),'Upload files')]");
        private By attachmentFile = By.className("integri-chat-message-attachment-file-name");

        public IntegryFileUploadPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open upload modal")
    public void openUploadModal(){
            driver.findElement(DnDButton).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(uploadModal)));
    }
    @Step("Upload file")
    public void FileUpload(String filePath) {
        File file = new File(filePath);
        String path = file.getAbsolutePath();
        driver.findElement(uploadButton).sendKeys(path);
        wait.until(ExpectedConditions.presenceOfElementLocated(addedFile));

    }
    @Step("Start upload")
    public void startUpload(){
            driver.findElement(startButton).click();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
    }
    @Step("Verify added files")
    public void verifyAddedFile(String expectedFile){
            String actualFile = driver.findElement(attachmentFile).getText();
            Assert.assertTrue(actualFile.contains(expectedFile));

    }
    @Step("Verify multiple add")
    public void verifyMultipleAdd(int expectedNum) {
        List<WebElement> addedFiles = driver.findElements(attachmentFile);
        int actualNum = addedFiles.size();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(attachmentFile));
        Assert.assertEquals(actualNum, expectedNum);
    }

}
