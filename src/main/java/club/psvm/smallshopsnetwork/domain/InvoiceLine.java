package club.psvm.smallshopsnetwork.domain;

import javax.persistence.*;
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
public class InvoiceLine {

     @Id @GeneratedValue
     Long id;

     @ManyToOne(targetEntity = Invoice.class,fetch = FetchType.EAGER)
     Invoice invoice;

     @ManyToOne(targetEntity = Stuff.class,fetch = FetchType.EAGER)
     Stuff stuff;

     BigDecimal count;

     BigDecimal price;

     boolean deleted;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public BigDecimal getTotal() {
        return price.multiply(count);
    }

}
