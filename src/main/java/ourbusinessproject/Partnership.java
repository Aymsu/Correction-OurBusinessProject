package ourbusinessproject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date creationDate;

    private String contributionDescription;

    @NotNull
    @ManyToOne
    private Project project;

    @NotNull
    @ManyToOne
    private Enterprise enterprise;

    public Partnership() {
    }

    public Partnership(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getContributionDescription() {
        return contributionDescription;
    }

    public void setContributionDescription(String contributionDescription) {
        this.contributionDescription = contributionDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
