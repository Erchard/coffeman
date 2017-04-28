package club.psvm.smallshopsnetwork.domain;

import javax.persistence.*;
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
public class MovementStuff {

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne(targetEntity = Store.class)
    Store storeSender;
    @ManyToOne(targetEntity = Store.class)
    Store storeRecipient;

    @Transient
    List<MovementLine> movementLineList = new ArrayList<>();

    boolean actual;

    boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStoreSender() {
        return storeSender;
    }

    public void setStoreSender(Store storeSender) {
        this.storeSender = storeSender;
    }

    public Store getStoreRecipient() {
        return storeRecipient;
    }

    public void setStoreRecipient(Store storeRecipient) {
        this.storeRecipient = storeRecipient;
    }

    public List<MovementLine> getMovementLineList() {
        return movementLineList;
    }

    public void setMovementLineList(List<MovementLine> movementLineList) {
        this.movementLineList = movementLineList;
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
