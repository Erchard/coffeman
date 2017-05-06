package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.domain.docs.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by andy on 30.04.17.
 */

@Component
public class InvoiceServiceImpl {

    private InvoiceService invoiceService;
    private ContractorService contractorService;

//    public void saveInvoice(String incomingNumber,
//                            String contractorName,
//                            String storeName,
//                            String total,
//                            String note) {
//
//        Invoice invoice = new Invoice();
//        Contractor contractor = contractorService.findOneByName(contractorName);
//        contractor.
//
//        invoice.setIncomingNumber(incomingNumber);
//        invoice.setContractor(contractorName);
//        invoice.setDateTime(LocalDateTime.now());
//        invoice.setIncomingNumber();
//        invoice.setIncomingNumber();
//
//        invoiceService.save();
//    }


    @Autowired
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    public void setContractorService(ContractorService contractorService) {
        this.contractorService = contractorService;
    }
}
