package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ourbusinessproject.repositories.PartnerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PartnerRepository partnerRepository;

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

    public Page<Partnership> findAll(Example<Partnership> partnershipExample, Pageable pageable) {
        return partnerRepository.findAll(partnershipExample,pageable);
    }

}
