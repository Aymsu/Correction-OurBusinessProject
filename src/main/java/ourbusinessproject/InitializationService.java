package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//@Transactional
public class InitializationService {

    private EnterpriseProjectService enterpriseProjectService;
    private PartnershipService partnershipService;

    private Project project1E1;
    private Project project2E1;
    private Project project1E2;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    private Partnership partnershipP1E1WithE2;
    private Partnership partnershipP1E2WithE1;
    private Partnership partnershipP2E1WithE2;


    @Autowired
    public InitializationService(EnterpriseProjectService enterpriseProjectService,
                                 PartnershipService partnershipService) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    public void initProjects() {
        initEnterprise1();
        initEnterprise2();

        initAndSaveProject1E1();
        initAndSaveProject1E2();
        initAndSaveProject2E1();

    }

    public void initPartnerships() {
        initAndSavePartnershipP1E1WithE2();
        initAndSavePartnershipP1E2WithE1();
        initAndSavePartnershipP2E1WithE2();
    }

    private void initAndSavePartnershipP1E1WithE2() {
        partnershipP1E1WithE2 = new Partnership();
        partnershipP1E1WithE2.setProject(project1E1);
        partnershipP1E1WithE2.setEnterprise(enterprise2);
        partnershipService.save(partnershipP1E1WithE2);
    }

    private void initAndSavePartnershipP1E2WithE1() {
        partnershipP1E2WithE1 = new Partnership();
        partnershipP1E2WithE1.setProject(project1E2);
        partnershipP1E2WithE1.setEnterprise(enterprise1);
        partnershipService.save(partnershipP1E2WithE1);
    }

    private void initAndSavePartnershipP2E1WithE2() {
        partnershipP2E1WithE2 = new Partnership();
        partnershipP2E1WithE2.setProject(project2E1);
        partnershipP2E1WithE2.setEnterprise(enterprise2);
        partnershipService.save(partnershipP2E1WithE2);
    }

    private void initAndSaveProject1E1() {
        project1E1 = new Project("p1e1","p1 e1 description", enterprise1);
        enterpriseProjectService.save(project1E1);
        enterprise1 = project1E1.getEnterprise();
    }

    private void initAndSaveProject1E2() {
        project1E2 = new Project("p1e2","p1 e2 description", enterprise2);
        enterpriseProjectService.save(project1E2);
        enterprise2 = project1E2.getEnterprise();
    }

    private void initAndSaveProject2E1() {
        project2E1 = new Project("p2e1","p2 e1 description", enterprise1);
        enterpriseProjectService.save(project2E1);
    }

    private void initEnterprise1() {
        enterprise1 = new Enterprise();
        enterprise1.setName("E1");
        enterprise1.setDescription("E1 description");
        enterprise1.setContactName("Paul Durand");
        enterprise1.setContactEmail("paul.durand@e1.com");
    }

    private void initEnterprise2() {
        enterprise2 = new Enterprise();
        enterprise2.setName("E2");
        enterprise2.setDescription("E2 description");
        enterprise2.setContactName("Paul Dupond");
        enterprise2.setContactEmail("paul.dupond@e2.com");
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }

    public Partnership getPartnershipP1E1WithE2() {
        return partnershipP1E1WithE2;
    }

    public Partnership getPartnershipP1E2WithE1() {
        return partnershipP1E2WithE1;
    }

    public Partnership getPartnershipP2E1WithE2() {
        return partnershipP2E1WithE2;
    }
}
