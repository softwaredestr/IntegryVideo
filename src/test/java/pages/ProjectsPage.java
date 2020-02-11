package pages;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
     By addedProject = By.className("project");
    //List<WebElement> addedProject;
    By edit = By.xpath("//div[@class='col-2 actions']//a[contains(text(),'Edit')]");

    By editForm = By.className("container-fluid");
    //WebElement editForm;
    @FindBy(className = "component new")
    WebElement addComponent;
    @FindBy(xpath = "//option")
    WebElement typeSelect;
    @FindBy(name = "name")
    WebElement componentName;
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open projects page")
    public ProjectsPage openPage(){
        driver.get("https://dev.integrivideo.com/app/projects");
        PageFactory.initElements(driver, ProjectsPage.this);
        return this;
    }
    @Step("Add project")
    public ProjectsPage addProject(){
        addProject.click();
        wait.until(ExpectedConditions.visibilityOf(createButton));
        return this;
    }
    @Step("Fill fields")
    public ProjectsPage fillFields(Project project){
        projectName.sendKeys(project.getProjectName());
        description.sendKeys(project.getDescription());
       for(int i = 0; i < project.getDomains().size(); i++){
          domains.get(i).sendKeys(project.getDomains().get(i));
       }
        return this;
    }
    @Step("Create project")
    public ProjectsPage сreateProject(){
        createButton.click();
        return this;
    }
    @Step("Verify count of projects")
    public int verifyCountProjects(){
        return driver.findElements(addedProject).size();

    }
    @Step("Click project")
    public int clickProject(int Num){
        verifyCountProjects();
        driver.findElements(addedProject).get(Num).click();
        return Num;
    }
    @Step("Click edit")
    public ProjectsPage clickEdit(){
        driver.findElement(edit).click();
        return this;
    }
    public ProjectsPage isEditOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editForm));
        return this;
    }
    @Step("Add new component")
    public ProjectsPage newComponent(){
        addComponent.click();
        return this;
    }
    @Step("Input components")
    public ProjectsPage inputComponents(int option, String name){
        Select select = new Select(typeSelect);
        select.getAllSelectedOptions().get(option);
        componentName.sendKeys(name);
        return this;
    }
    @Step("Click create button")
    public ProjectsPage create(){
        createButton.click();
        return this;
    }

}
