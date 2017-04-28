package club.psvm.smallshopsnetwork.domain;

import javax.persistence.*;
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
public class InvoiceLine {

     @Id @GeneratedValue
     Long id;

     @ManyToOne(targetEntity = Invoice.class,fetch = FetchType.EAGER)
     Invoice invoice;

     @ManyToOne(targetEntity = Stuff.class,fetch = FetchType.EAGER)
     Stuff stuff;

     BigDecimal quantity;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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
        return price.multiply(quantity);
    }

}
