package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.CashBox;
import club.psvm.smallshopsnetwork.domain.Product;
import club.psvm.smallshopsnetwork.domain.Unit;
import club.psvm.smallshopsnetwork.domain.actors.Company;
import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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


    public void init() {

        initProducts();

    }

    private Contractor getContractor(String name) {

        List<Contractor> contractorList = (List<Contractor>) contractorRepository.findAll();
        if (contractorList == null || contractorList.size() == 0) {
            CashBox cashBox = new CashBox(getCompany());
            cashBoxRepository.save(cashBox);
            Contractor contractor = new Contractor(name, cashBox);
            contractorRepository.save(contractor);
            return contractor;
        }
        else
            return contractorList.get(0);
    }


    private void initProducts() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        if (productList == null || productList.size() == 0) {
            createNewProduct("Молоко", "шт", "18.00");
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
