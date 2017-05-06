package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.domain.elements.CashBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andy on 02.05.17.
 */

@Component
public class ContractorServiceImpl {

    private ContractorService contractorService;
    private CashBoxServiceImpl cashBoxService;

    public Contractor findOneById(Long id) {
        return contractorService.findOneById(id);
    }

    public List<Contractor> findAll() {
        return contractorService.findAll();
    }


    public void save(String name, String telNumber, String comment) {

        CashBox newCashBox = new CashBox();
        cashBoxService.save(newCashBox);

        Contractor newContractor = new Contractor();
        newContractor.setName(name);
        newContractor.setTelNumber(telNumber);
        newContractor.setComment(comment);
        newContractor.setCashBox(newCashBox);
        contractorService.save(newContractor);
    }

    public void save(Contractor contractor) {
        contractorService.save(contractor);
    }


    public void remove(Long id) {
        contractorService.remove(id);
    }


    @Autowired
    public void setContractorService(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @Autowired
    public void setCashBoxService(CashBoxServiceImpl cashBoxService) {
        this.cashBoxService = cashBoxService;
    }
}
