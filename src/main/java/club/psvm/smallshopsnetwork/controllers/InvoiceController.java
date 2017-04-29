package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.domain.docs.Invoice;
import club.psvm.smallshopsnetwork.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping("/invoices")
    String invoiceList(ModelMap modelMap){
        modelMap.addAttribute("invoiceList", invoiceService.findAll());

        return "invoices";
    }

    @RequestMapping("/invoice/{id}")
    String invoiceDetail(ModelMap modelMap, @PathVariable Long id){

        modelMap.addAttribute("invoice",invoiceService.findOneById(id));

        return "invoice";
    }


}
