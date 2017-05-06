package club.psvm.smallshopsnetwork.domain.elements;

import club.psvm.smallshopsnetwork.domain.actors.Company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by JAVA-P on 28.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/

 @Entity
public class CashBox {

     @Id @GeneratedValue
    Long account;


    @ManyToOne
    Company company;

    public CashBox() {
    }

    public CashBox(Company company) {
        this.company = company;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
