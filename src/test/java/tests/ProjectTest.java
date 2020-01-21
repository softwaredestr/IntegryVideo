package tests;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectsPage;

public class ProjectTest extends BaseTest {
    @Test
    public void Project(){
        User user = new User("qwerty@mailinator.com", "12345678");
        Project project = new Project("qwe","sadasdas","tut.by");
        new LogInPage(driver)
                .openPage()
                .LogIn(user);
        new ProjectsPage(driver)
                .openPage()
                .addProject()
                .projectCreate(project)
                .addProject()
                .projectCreate(project)
                .verifyCountProjects(2);





    }
}
