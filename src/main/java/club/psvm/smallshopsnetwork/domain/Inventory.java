package club.psvm.smallshopsnetwork.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;
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
public class Inventory {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime dateTime;

    @Transient
    List<InventoryLine> inventoryLineList = new ArrayList<>();

    boolean deleted;
}
