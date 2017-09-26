package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Project project) {
        entityManager.persist(project);
    }

}
