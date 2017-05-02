package club.psvm.smallshopsnetwork.domain.docs;

import club.psvm.smallshopsnetwork.domain.elements.RawStuff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/
@Entity
public class InventoryLine {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(targetEntity = Inventory.class)
    Inventory inventory;

    @ManyToOne(targetEntity = RawStuff.class)
    RawStuff rawStuff;

    BigDecimal accountingSumm;

    BigDecimal expectedQuantity;

    BigDecimal realQuantity;


    boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public RawStuff getRawStuff() {
        return rawStuff;
    }

    public void setRawStuff(RawStuff rawStuff) {
        this.rawStuff = rawStuff;
    }

    public BigDecimal getAccountingPrice() {
        return accountingSumm.divide(expectedQuantity);
    }

    public BigDecimal getAccountingSumm() {
        return accountingSumm;
    }

    public void setAccountingSumm(BigDecimal accountingSumm) {
        this.accountingSumm = accountingSumm;
    }

    public BigDecimal getExpectedQuantity() {
        return expectedQuantity;
    }

    public void setExpectedQuantity(BigDecimal expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
    }

    public BigDecimal getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(BigDecimal realQuantity) {
        this.realQuantity = realQuantity;
    }

    public BigDecimal getDifference() {
        return realQuantity.subtract(expectedQuantity);
    }

    public BigDecimal getDifferenceSumm() {
        return getDifference().multiply(getAccountingPrice());
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
