package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.services.ContractorService;
import club.psvm.smallshopsnetwork.services.ContractorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by andy on 30.04.17.
 */

@Controller
public class ContractorController {

    private ContractorServiceImpl contractorService;

    @RequestMapping("/contractors")
    String contractorList(ModelMap modelMap) {
        modelMap.addAttribute("contractorList", contractorService.findAll());
        return "contractors";
    }


    @RequestMapping("/createContractor")
    String createContractor() {
        return "createContractor";
    }


    @RequestMapping(value = "/contractor/create", method = RequestMethod.POST)
    String isCreated(@RequestParam String name,
                     @RequestParam String telNumber,
                     @RequestParam String comment) {
        contractorService.save(name, telNumber, comment);
        return "redirect:/contractors";
    }

    @RequestMapping(value = "/contractor/edit", method = RequestMethod.POST)
    String edit(@ModelAttribute Contractor contractor) {
        contractorService.save(contractor);
        return "redirect:/contractors";
    }

    @RequestMapping("/contractor/{id}")
    String contractorDetail(ModelMap modelMap, @PathVariable Long id) {
        modelMap.addAttribute("contractor", contractorService.findOneById(id));
        return "contractor";
    }

    @RequestMapping("/contractor/remove/{id}")
    String remove(@PathVariable Long id) {
        contractorService.remove(id);
        return "redirect:/contractors";
    }



    @Autowired
    public void setContractorService(ContractorServiceImpl contractorService) {
        this.contractorService = contractorService;
    }
}
