package club.psvm.smallshopsnetwork.domain.elements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.psvm.club
 * Все права на данный программный код принадлежат компании PSVM.club
 * Created by www.psvm.club
 * All rights to the software code are owned by PSVM.club
*/

@Entity
public class Stuff {

    @Id
    @GeneratedValue
    Long id;

    String name;

    BigDecimal accountingPrice;

    @ManyToOne(targetEntity = RawStuff.class)
    RawStuff rawStuff;

    BigDecimal rawFactor;

    @ManyToOne(targetEntity = Unit.class)
    Unit unit;

    boolean deleted;

    public Stuff() {
    }

    public Stuff(String name, BigDecimal accountingPrice, RawStuff rawStuff, BigDecimal rawFactor, Unit unit) {
        this.name = name;
        this.accountingPrice = accountingPrice;
        this.rawStuff = rawStuff;
        this.rawFactor = rawFactor;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAccountingPrice() {
        return accountingPrice;
    }

    public void setAccountingPrice(BigDecimal accountingPrice) {
        this.accountingPrice = accountingPrice;
    }

    public RawStuff getRawStuff() {
        return rawStuff;
    }

    public void setRawStuff(RawStuff rawStuff) {
        this.rawStuff = rawStuff;
    }

    public BigDecimal getRawFactor() {
        return rawFactor;
    }

    public void setRawFactor(BigDecimal rawFactor) {
        this.rawFactor = rawFactor;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
