package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.domain.docs.Invoice;
import club.psvm.smallshopsnetwork.domain.docs.InvoiceLine;
import club.psvm.smallshopsnetwork.services.ContractorService;
import club.psvm.smallshopsnetwork.services.InvoiceService;
import club.psvm.smallshopsnetwork.services.StoreService;
import club.psvm.smallshopsnetwork.services.StuffService;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Controller
public class InvoiceController {

    private InvoiceService invoiceService;
    private ContractorService contractorService;
    private StoreService storeService;
    private StuffService stuffService;

    @RequestMapping("/invoices")
    String invoiceList(ModelMap modelMap){
        modelMap.addAttribute("invoiceList", invoiceService.findAll());

        return "invoices";
    }

    @RequestMapping("/invoice/{id}")
    String invoiceDetail(ModelMap modelMap, @PathVariable Long id){

        modelMap.addAttribute("invoice", invoiceService.findOneById(id));
        return "invoice";
    }


    @RequestMapping(value = "/invoice/create", method = RequestMethod.GET)
    String createInvoice() {
        Long id = invoiceService.getNew().getId();
        return "redirect:/invoice/edit/" + id;
    }


    @RequestMapping("/invoice/edit/{id}")
    String editInvoice(ModelMap modelMap, @PathVariable Long id) {

        modelMap.addAttribute("invoice", invoiceService.findOneById(id));
        modelMap.addAttribute("contractorList", contractorService.findAll());
        modelMap.addAttribute("storeList", storeService.findAll());
        modelMap.addAttribute("stuffList", stuffService.findAll());

        return "createInvoice";
    }


    @RequestMapping(value = "/invoice/save", method = RequestMethod.POST)
    String saveInvoice(@RequestParam Long id,
                       @RequestParam String incomingNumber,
                       @RequestParam(name = "contractor.id") Long contractor_id,
                       @RequestParam String dateTime,
                       @RequestParam(name = "store.id") Long store_id,
                       @RequestParam boolean actual,
                       @RequestParam String note) {


        //TODO: save params

        return "redirect:/invoice/edit/" + id;
    }



    @Autowired
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    public void setContractorService(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @Autowired
    public void setStuffService(StuffService stuffService) {
        this.stuffService = stuffService;
    }
}
