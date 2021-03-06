package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.services.InventoryServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Controller
public class InventoryController {

    @Autowired
    InventoryServise inventoryServise;


    @RequestMapping("/inventories")
    String getAllInventories(ModelMap modelMap){



        modelMap.addAttribute("inventoryList",inventoryServise.findAll());

        return "inventories";
    }

    @RequestMapping("/inventory/{id}")
    String oneInventory(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("inventory",inventoryServise.findOne(id));
        return "inventory";
    }
}
