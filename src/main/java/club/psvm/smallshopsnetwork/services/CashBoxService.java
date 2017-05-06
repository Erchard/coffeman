package club.psvm.smallshopsnetwork.services;


import club.psvm.smallshopsnetwork.domain.elements.CashBox;
import club.psvm.smallshopsnetwork.repositories.CashBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andy on 02.05.17.
 */

@Service
public class CashBoxService {

    private CashBoxRepository cashBoxRepository;

    public void save(CashBox cashBox) {
        cashBoxRepository.save(cashBox);
    }

    @Autowired
    public void setCashBoxRepository(CashBoxRepository cashBoxRepository) {
        this.cashBoxRepository = cashBoxRepository;
    }
}
