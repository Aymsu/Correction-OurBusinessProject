package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartnershipController {

    private EnterpriseProjectService enterpriseProjectService;
    private PartnershipService partnershipService;

    @Autowired
    public PartnershipController(EnterpriseProjectService enterpriseProjectService, PartnershipService partnershipService) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    @RequestMapping(value = "/api/v1/partnerships", method = RequestMethod.POST)
    public Partnership addPartnership(@RequestParam(value = "project_id")Long projectId, @RequestParam(value = "enterprise_id")Long enterpriseId) {
        Project project = enterpriseProjectService.findProjectById(projectId);
        Enterprise enterprise = enterpriseProjectService.findEnterpriseById(enterpriseId);
        Partnership partnership = new Partnership();
        partnership.setProject(project);
        partnership.setEnterprise(enterprise);
        partnershipService.save(partnership);
        return partnership;
    }

    @RequestMapping(value = "/api/v1/partnerships/{partnership_id}", method = RequestMethod.DELETE)
    public void removePartnership(@PathVariable("partnership_id")Long partnershipId) {
        Partnership partnership = partnershipService.findPartnershipById(partnershipId);
        partnershipService.remove(partnership);
    }

    @RequestMapping(value = "/api/v1/partnerships/search", method = RequestMethod.GET)
    public Page<Partnership> searchInscriptions(@RequestParam(value = "project_title",required = false)String projectTitle,
                                                @RequestParam(value = "enterprise_name",required = false)String enterpriseName,
                                                Pageable pageable) {
        Example<Partnership> example = getPartnershipExample(projectTitle, enterpriseName);
        Page<Partnership> res = partnershipService.findAll(example, pageable);
        return res;
    }

    private Example<Partnership> getPartnershipExample(String projectTitle, String enterpriseName) {
        Partnership partnership = new Partnership();
        if (projectTitle != null) {
            Project project = new Project();
            project.setTitle(projectTitle);
            partnership.setProject(project);
        }
        if (enterpriseName != null) {
            Enterprise enterprise = new Enterprise();
            enterprise.setName(enterpriseName);
            partnership.setEnterprise(enterprise);
        }

        return Example.of(partnership);
    }

}
