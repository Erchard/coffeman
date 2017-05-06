package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.docs.Invoice;
import club.psvm.smallshopsnetwork.domain.docs.InvoiceLine;
import club.psvm.smallshopsnetwork.repositories.InvoiceLineRepository;
import club.psvm.smallshopsnetwork.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAVA-P on 28.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceLineRepository invoiceLineRepository;

    public Invoice findOneById(Long id) {

        Invoice invoice = invoiceRepository.findOne(id);
        return fillLines(invoice);
    }

    public Invoice fillLines(Invoice invoice) {
        if (invoice == null) return new Invoice();

        List<InvoiceLine> lineList = invoiceLineRepository.findAllByInvoice(invoice);
        if (lineList != null) {
            lineList.removeIf(InvoiceLine::isDeleted);
            invoice.setInvoiceLineList(lineList);
        }
        return invoice;
    }


    //TODO: findAll by Company
    public List<Invoice> findAll() {
        List<Invoice> invoiceList = (List<Invoice>) invoiceRepository.findAll();
        if(invoiceList==null || invoiceList.size()==0){
            return new ArrayList<>();
        }
        else {
            invoiceList.removeIf(Invoice::isDeleted);
            invoiceList.forEach(invoice -> fillLines(invoice));
            return invoiceList;
        }
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }


    public  Invoice getNew() {

        Invoice invoice = new Invoice();
        invoice.setDeleted(true);
        invoice.setDateTime(LocalDateTime.now());
        invoiceRepository.save(invoice);
        return invoice;
    }

}
