package club.psvm.smallshopsnetwork.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/

 @Entity
public class Invoice {

     @Id @GeneratedValue
     Long id;


     LocalDateTime dateTime;

     @ManyToOne(targetEntity = Contractor.class, fetch = FetchType.EAGER)
     Contractor contractor;



     boolean deleted;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
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

     public boolean isDeleted() {
          return deleted;
     }

     public void setDeleted(boolean deleted) {
          this.deleted = deleted;
     }
}
