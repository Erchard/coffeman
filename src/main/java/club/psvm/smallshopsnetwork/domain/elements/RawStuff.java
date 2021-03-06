package club.psvm.smallshopsnetwork.domain.elements;

import club.psvm.smallshopsnetwork.domain.actors.Company;

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
public class RawStuff {

    @Id
    @GeneratedValue
    Long id;

    String name;


    @ManyToOne
    Company company;

    BigDecimal accountingPrice;

    @ManyToOne(targetEntity = Unit.class)
    Unit unit;

    public RawStuff() {
    }

    public RawStuff(String name, Company company, BigDecimal accountingPrice, Unit unit) {
        this.name = name;
        this.company = company;
        this.accountingPrice = accountingPrice;
        this.unit = unit;
    }

    boolean deleted;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BigDecimal getAccountingPrice() {
        return accountingPrice;
    }

    public void setAccountingPrice(BigDecimal accountingPrice) {
        this.accountingPrice = accountingPrice;
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
