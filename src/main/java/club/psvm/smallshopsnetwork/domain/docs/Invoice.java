package club.psvm.smallshopsnetwork.domain.docs;

import club.psvm.smallshopsnetwork.domain.actors.Contractor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.psvm.club
 * Все права на данный программный код принадлежат компании PSVM.club
 * Created by www.psvm.club
 * All rights to the software code are owned by PSVM.club
*/

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    Long id;

    String incomingNumber;

    LocalDateTime dateTime;

    @ManyToOne(targetEntity = Contractor.class, fetch = FetchType.EAGER)
    Contractor contractor;

    @Transient
    List<InvoiceLine> invoiceLineList = new ArrayList<>();

    String note = "";

    boolean actual;

    boolean deleted;

    public Invoice() {
    }

    public Invoice(String incomingNumber, LocalDateTime dateTime, Contractor contractor, boolean actual) {
        this.incomingNumber = incomingNumber;
        this.dateTime = dateTime;
        this.contractor = contractor;
        this.actual = actual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncomingNumber() {
        return incomingNumber;
    }

    public void setIncomingNumber(String incomingNumber) {
        this.incomingNumber = incomingNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public List<InvoiceLine> getInvoiceLineList() {
        return invoiceLineList;
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        this.invoiceLineList = invoiceLineList;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal("0.00");

        for (InvoiceLine invoiceLine : invoiceLineList) {
            total = total.add(invoiceLine.getTotal());

        }

        return total.setScale(2, BigDecimal.ROUND_HALF_UP);
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
