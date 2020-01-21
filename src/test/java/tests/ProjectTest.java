package tests;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectsPage;

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectTest extends BaseTest {
    @Test
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
                .editProject();








    }
}
