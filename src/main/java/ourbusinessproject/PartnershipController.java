package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
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

}
