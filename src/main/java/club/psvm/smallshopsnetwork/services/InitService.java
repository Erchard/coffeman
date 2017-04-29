package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.elements.*;
import club.psvm.smallshopsnetwork.domain.actors.Company;
import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.domain.docs.Invoice;
import club.psvm.smallshopsnetwork.domain.docs.InvoiceLine;
import club.psvm.smallshopsnetwork.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
public class InitService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    CashBoxRepository cashBoxRepository;

    @Autowired
    ContractorRepository contractorRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceLineRepository invoiceLineRepository;

    @Autowired
    StuffRepository stuffRepository;

    @Autowired
    RawStuffRepository rawStuffRepository;


    public void init() {

        initInvoice();

    }

    private void initInvoice() {
        List<Invoice> invoiceList = (List<Invoice>) invoiceRepository.findAll();
        if (invoiceList == null || invoiceList.size() == 0) {
            Invoice invoice = new Invoice("ТН-345654", LocalDateTime.now(), getContractor(), true);
            invoiceRepository.save(invoice);

            createNewInvoiceLine(invoice, "молоко Хэппи", "молоко", "4", "18.00",
                    "0.9", "шт", "л");
            createNewInvoiceLine(invoice, "сахар Белый", "сахар", "10.00", "10.00",
                    "1", "кг", "кг");
            createNewInvoiceLine(invoice, "стаканчик Fortune 200", "стакан 200 мл", "400", "0.10",
                    "1", "шт", "шт");
        }
    }

    void createNewInvoiceLine(Invoice invoice, String name, String rawStuff, String quantity, String price,
                              String rawFactor, String stuffUnit, String rawUnit) {
        Stuff stuff = getStuff(name, price, rawFactor, rawStuff, stuffUnit, rawUnit);
        InvoiceLine invoiceLine = new InvoiceLine(invoice, stuff, new BigDecimal(quantity), new BigDecimal(price));
        invoiceLineRepository.save(invoiceLine);
    }

    private Stuff getStuff(String name, String price, String rawFactor, String rawStuff, String stuffUnit, String rawUnit) {
        List<Stuff> stuffList = stuffRepository.findAllByName(name);
        if (stuffList == null || stuffList.size() == 0) {
            Stuff stuff = new Stuff(name, new BigDecimal(price), getRawStuff(rawStuff, price, rawFactor, rawUnit),
                    new BigDecimal(rawFactor), getUnit(stuffUnit));
            stuffRepository.save(stuff);
            return stuff;
        } else
            return stuffList.get(0);
    }

    private RawStuff getRawStuff(String name, String stuffPrice, String rawFactor, String unit) {
        List<RawStuff> rawStuffList = rawStuffRepository.findAllByName(name);
        if (rawStuffList == null || rawStuffList.size() == 0) {
            BigDecimal price = new BigDecimal(stuffPrice);
            BigDecimal factor = new BigDecimal(rawFactor);
            RawStuff rawStuff = new RawStuff(name, getCompany(), price.divide(factor), getUnit(unit));
            rawStuffRepository.save(rawStuff);
            return rawStuff;
        } else
            return rawStuffList.get(0);
    }


    private Contractor getContractor() {

        List<Contractor> contractorList = (List<Contractor>) contractorRepository.findAll();
        if (contractorList == null || contractorList.size() == 0) {
            CashBox cashBox = new CashBox(getCompany());
            cashBoxRepository.save(cashBox);
            Contractor contractor = new Contractor("Best Supplier Ltd.", cashBox);
            contractorRepository.save(contractor);
            return contractor;
        } else
            return contractorList.get(0);
    }


    private void initProducts() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        if (productList == null || productList.size() == 0) {
            createNewProduct("Латте", "шт", "27.00");
        }

    }

    private Product createNewProduct(String name, String units, String price) {
        Product product = new Product(name, getCompany(), new BigDecimal(price), getUnit(units));
        productRepository.save(product);
        return product;
    }

    private Company getCompany() {
        List<Company> companyList = (List<Company>) companyRepository.findAll();
        if (companyList == null || companyList.size() == 0) {
            Company company = new Company("Small Shop Co");
            companyRepository.save(company);
            return company;
        } else {
            return companyList.get(0);
        }
    }

    private Unit getUnit(String units) {
        List<Unit> unitList = unitRepository.findAllByNameAndDeleted(units, false);
        if (unitList == null || unitList.size() == 0) {
            Unit unit = new Unit(units);
            unitRepository.save(unit);
            return unit;
        } else return unitList.get(0);
    }
}
