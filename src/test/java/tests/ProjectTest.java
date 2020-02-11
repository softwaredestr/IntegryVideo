package tests;

import Utils.AllureUtils;
import io.qameta.allure.Description;
import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectsPage;

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectTest extends BaseTest {
    ProjectsPage project;
    @Test(description = "Create project")
    @Description("Создание проекта")
    public void Project(){
        User user = new User("qwerty@mailinator.com", "12345678");
        Project project = new Project("qwe","sadasdas",
                new ArrayList<String>(Arrays.asList("tut.by", "onliner.by", "av.by")));
        new LogInPage(driver)
                .openPage()
                .LogIn(user);
        new ProjectsPage(driver)
                .openPage()
                .addProject()
                .fillFields(project)
                .сreateProject()
                .verifyCountProjects();
        AllureUtils.takeScreenshot(driver);
    }
    @Test(description = "Edit project")
    @Description("Редактирование проекта")
    public void editProject(){
        User user = new User("qwerty@mailinator.com", "12345678");
        new LogInPage(driver)
                .openPage()
                .LogIn(user);
        project = new ProjectsPage(driver);
        project.verifyCountProjects();
        project.clickProject(1);
        project.isEditOpened();
        project.clickEdit();
        driver.navigate().back();
        project.newComponent();
        project.inputComponents(2, "qwerty");
        AllureUtils.takeScreenshot(driver);
        project.create();






    }
}
