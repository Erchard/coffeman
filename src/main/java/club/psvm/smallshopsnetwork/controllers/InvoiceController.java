package club.psvm.smallshopsnetwork.controllers;

import club.psvm.smallshopsnetwork.domain.docs.Invoice;
import club.psvm.smallshopsnetwork.domain.docs.InvoiceLine;
import club.psvm.smallshopsnetwork.services.ContractorService;
import club.psvm.smallshopsnetwork.services.InvoiceService;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Controller
public class InvoiceController {

    private InvoiceService invoiceService;
    private ContractorService contractorService;
//    private

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


    @RequestMapping("/createinvoice")
    String createInvoice(ModelMap modelMap) {

        modelMap.addAttribute("invoice", invoiceService.getNew());
        modelMap.addAttribute("contractorList", contractorService.findAll());
        return "createInvoice";
    }


    @RequestMapping(value = "/invoice/create", method = RequestMethod.POST)
    String isCreated(@RequestParam String incomingNumber,
                     @RequestParam String contractorName,
                     @RequestParam String storeName,
                     @RequestParam String total,
                     @RequestParam String note) {



//        System.out.println(id);

        return "redirect:/invoices";
    }


    @RequestMapping(value="/seedstartermng", params={"addRow"})
    public String addRow(final Invoice invoice, final BindingResult bindingResult) {
        invoice.getInvoiceLineList().add(new InvoiceLine());
        return "redirect:/createInvoice";
    }


    @Autowired
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    public void setContractorService(ContractorService contractorService) {
        this.contractorService = contractorService;
    }
}
