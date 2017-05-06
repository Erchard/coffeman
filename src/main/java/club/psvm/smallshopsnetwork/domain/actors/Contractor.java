package club.psvm.smallshopsnetwork.domain.actors;

import club.psvm.smallshopsnetwork.domain.elements.CashBox;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.psvm.club
 * Все права на данный программный код принадлежат компании PSVM.club
 * Created by www.psvm.club
 * All rights to the software code are owned by PSVM.club
*/

@Entity
public class Contractor {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    private String telNumber;
    private String comment;

    @OneToOne
    private CashBox cashBox;

    private boolean deleted;

    public Contractor() {
    }

    public Contractor(String name, CashBox cashBox) {
        this.name = name;
        this.cashBox = cashBox;
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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
