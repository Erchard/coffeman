package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by JAVA-P on 28.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/

@Controller
public class UnitsController {

    @Autowired
    UnitService unitService;


    @RequestMapping("/units")
    String findAll(ModelMap modelMap) {
        modelMap.addAttribute("units", unitService.findAll());
        return "units";
    }


    @RequestMapping(value = "/units/delete", method = RequestMethod.POST)
    String delete(@RequestParam Long id) {
        unitService.delete(id);
        return "redirect:/units";
    }

}
