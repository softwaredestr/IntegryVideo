package models;

public class Project {
    String projectName;
    String description;
    String domains;

    public Project(String projectName, String description, String domains) {
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

    public void setDomains(String domains) {
        this.domains = domains;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public String getDomains() {
        return domains;
    }
}
