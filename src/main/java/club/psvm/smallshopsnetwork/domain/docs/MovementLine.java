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
public class MovementLine {

     @Id
     @GeneratedValue
     Long id;

     @ManyToOne(targetEntity = MovementStuff.class)
     MovementStuff movementStuff;

     @ManyToOne(targetEntity = RawStuff.class)
     RawStuff rawStuff;

     BigDecimal quantity;

    BigDecimal accountingPrice;

    boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovementStuff getMovementStuff() {
        return movementStuff;
    }

    public void setMovementStuff(MovementStuff movementStuff) {
        this.movementStuff = movementStuff;
    }

    public RawStuff getRawStuff() {
        return rawStuff;
    }

    public void setRawStuff(RawStuff rawStuff) {
        this.rawStuff = rawStuff;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAccountingPrice() {
        return accountingPrice;
    }

    public void setAccountingPrice(BigDecimal accountingPrice) {
        this.accountingPrice = accountingPrice;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
