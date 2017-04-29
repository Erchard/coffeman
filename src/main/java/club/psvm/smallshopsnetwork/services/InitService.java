package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.CashBox;
import club.psvm.smallshopsnetwork.domain.Unit;
import club.psvm.smallshopsnetwork.domain.actors.Company;
import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.repositories.CashBoxRepository;
import club.psvm.smallshopsnetwork.repositories.CompanyRepository;
import club.psvm.smallshopsnetwork.repositories.ContractorRepository;
import club.psvm.smallshopsnetwork.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class InitService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    CashBoxRepository cashBoxRepository;

    @Autowired
    ContractorRepository contractorRepository;

    Company company = null;

    public void init() {
        initCompany();
        initUnits();
        initContractor();


    }


    private void initCompany() {
        List<Company> companyList = (List<Company>) companyRepository.findAll();
        if (companyList == null || companyList.size() == 0) {
            company = new Company("Small Shop Co");
            companyRepository.save(company);
        } else {
            company = companyList.get(0);
        }
    }

    private void initUnits() {

        List<Unit> unitList = (List<Unit>) unitRepository.findAll();
        if (unitList == null || unitList.size() == 0) {
            List<Unit> units = new ArrayList<>();
            units.add(new Unit("кг"));
            units.add(new Unit("шт"));
            units.add(new Unit("л"));
            unitRepository.save(units);
        }
    }

    private void initContractor() {

        List<Contractor> contractorList = (List<Contractor>) contractorRepository.findAll();
        if (contractorList == null || contractorList.size() == 0) {
            if (company == null) initCompany();
            CashBox cashBox = new CashBox(company);
            cashBoxRepository.save(cashBox);
            Contractor contractor = new Contractor("Supplier of products", cashBox);
            contractorRepository.save(contractor);
        }

    }
}
