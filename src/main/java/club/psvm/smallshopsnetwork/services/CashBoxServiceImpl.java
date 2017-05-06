package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.elements.CashBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by andy on 02.05.17.
 */

@Component
public class CashBoxServiceImpl {

    private CashBoxService cashBoxService;

    public void save(CashBox cashBox) {
        cashBoxService.save(cashBox);
    }

    @Autowired
    public void setCashBoxService(CashBoxService cashBoxService) {
        this.cashBoxService = cashBoxService;
    }
}
