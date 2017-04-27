package club.psvm.smallshopsnetwork.domain;

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
public class RecipeLine {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Recipe recipe;

    @ManyToOne(targetEntity = RawStuff.class)
    RawStuff rawStuff;

    BigDecimal quantity;

    boolean deleted;

}
