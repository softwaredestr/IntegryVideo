package pages;

import models.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProjectsPage extends BasePage{
    @FindBy(xpath = "//a[@href='/app/projects/new']" )
    WebElement addProject;
    @FindBy(name = "name")
    WebElement projectName;
    @FindBy(xpath = "//input[@name='domains[]'][1]")
    WebElement description;
    @FindBy(name = "domains[]")
    List<WebElement> domains;
    @FindBy(className = "btn")
    WebElement createButton;
    @FindBy(className = "project")
    List<WebElement> addedProject;
    @FindBy(xpath = "//div[@class='col-2 actions']//a[contains(text(),'Edit')] ")
    WebElement edit;
    @FindBy(className = "integri-video app projects edit form")
    WebElement editForm;
    @FindBy(className = "component new")
    WebElement addComponent;
    @FindBy(xpath = "//option")
    WebElement TypeSelect;
    @FindBy(name = "name")
    WebElement componentName;
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage openPage(){
        driver.get("https://dev.integrivideo.com/app/projects");
        PageFactory.initElements(driver, ProjectsPage.this);
        return this;
    }
    public ProjectsPage addProject(){
        addProject.click();
        wait.until(ExpectedConditions.visibilityOf(createButton));
        return this;
    }
    public ProjectsPage fillFields(Project project){
        projectName.sendKeys(project.getProjectName());
        description.sendKeys(project.getDescription());
       for(int i = 0; i < project.getDomains().size(); i++){
          domains.get(i).sendKeys(project.getDomains().get(i));
       }
        return this;
    }
    public ProjectsPage сreateProject(){
        createButton.click();
        return this;
    }
    public int verifyCountProjects(){
        return addedProject.size();
    }
    public ProjectsPage editProject(){
        addedProject.get(0).click();
        return this;
    }

}
