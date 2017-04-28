package club.psvm.smallshopsnetwork.domain;

import javax.persistence.*;

/**
 * Created by JAVA-P on 27.04.2017.
 */
 
 /* Создано в www.psvm.club
 * Все права на данный программный код принадлежат компании PSVM.club
 * Created by www.psvm.club
 * All rights to the software code are owned by PSVM.club
*/

 @Entity
public class Contractor  {

     @Id
     @GeneratedValue
     Long id;

     String name;



     @OneToOne
     CashBox cashBox;

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
