package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;

/**
 * Created by arsenguzhva on 5/2/2017.
 */
@Controller
public class MovementController {

    @Autowired
    MovementService movementService;

    @RequestMapping("/movements")
    String findAll(ModelMap modelMap){

        modelMap.addAttribute("movements",movementService.findAll());
        return "movements";
    }


    @RequestMapping("/movement/{id}")
    String findOne(ModelMap modelMap, @PathVariable Long id){


        return "movement";
    }
}
