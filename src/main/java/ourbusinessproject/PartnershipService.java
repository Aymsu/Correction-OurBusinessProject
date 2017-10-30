package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    public Partnership save(Partnership partnership) {
        partnership.setCreationDate(new Date());
        entityManager.persist(partnership);
        return partnership;
    }

    public void remove(Partnership partnership) {
        if (!entityManager.contains(partnership)) {
            partnership = entityManager.merge(partnership);
        }
        entityManager.remove(partnership);
    }

    public Partnership findPartnershipById(Long id) {
        return entityManager.find(Partnership.class, id);
    }

}
