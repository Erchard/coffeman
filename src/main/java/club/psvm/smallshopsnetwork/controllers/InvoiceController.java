package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping
    String invoiceList(ModelMap modelMap){
        modelMap.addAttribute("invoiceList", invoiceService.findAll());

        return "invoices";
    }

}
