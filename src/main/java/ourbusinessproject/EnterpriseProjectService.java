package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Project project) {
        Enterprise enterprise = project.getEnterprise();
        if (enterprise.getId() == null) {
            save(enterprise);
        }
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


    public List<Project> findAllProjects() {
        TypedQuery<Project> query = entityManager.createQuery("select p from Project p order by p.title", Project.class);
        return query.getResultList();
    }
}
