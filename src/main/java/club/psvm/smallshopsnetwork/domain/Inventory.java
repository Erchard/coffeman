package club.psvm.smallshopsnetwork.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/
@Entity
public class Inventory {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime dateTime;

    @ManyToOne(targetEntity = Store.class)
    Store store;

    @Transient
    List<InventoryLine> inventoryLineList = new ArrayList<>();


    boolean actual;

    boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<InventoryLine> getInventoryLineList() {
        return inventoryLineList;
    }

    public void setInventoryLineList(List<InventoryLine> inventoryLineList) {
        this.inventoryLineList = inventoryLineList;
    }


    public BigDecimal getExpectedTotalSumm() {

        BigDecimal expectedTotalSumm = new BigDecimal("0.00");
        for (InventoryLine inventoryLine : inventoryLineList) {
            expectedTotalSumm = expectedTotalSumm.add(inventoryLine.getExpectedQuantity().multiply(inventoryLine.getAccountingPrice()));
        }
        return expectedTotalSumm;
    }

    public BigDecimal getRealTotalSumm() {
        BigDecimal realTotalSumm = new BigDecimal("0.00");
        for (InventoryLine inventoryLine : inventoryLineList) {
            realTotalSumm = realTotalSumm.add(inventoryLine.getRealQuantity().multiply(inventoryLine.getAccountingPrice()));
        }

        return realTotalSumm;
    }

    public BigDecimal getDifferenceTotalSumm() {
        BigDecimal differenceTotalSumm = new BigDecimal("0.00");
        for (InventoryLine inventoryLine : inventoryLineList) {
            differenceTotalSumm = differenceTotalSumm.add(inventoryLine.getDifferenceSumm());
        }

        return differenceTotalSumm;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
