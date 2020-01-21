package models;

import java.util.ArrayList;

public class Project {
    public Project(String projectName, String description, ArrayList<String> domains) {
        this.projectName = projectName;
        this.description = description;
        this.domains = domains;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDomains(ArrayList<String> domains) {
        this.domains = domains;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    String projectName;
    String description;
    ArrayList<String> domains;

}