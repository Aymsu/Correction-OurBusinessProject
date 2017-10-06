package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Project project) {
        Enterprise enterprise = project.getEnterprise();
        save(enterprise);
        if (enterprise.getProjects() == null) {
            enterprise.setProjects(new ArrayList<>());
        }
        enterprise.getProjects().add(project);
        entityManager.persist(project);
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
    }

    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id) {
        return entityManager.find(Enterprise.class, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
