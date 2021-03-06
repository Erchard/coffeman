package club.psvm.smallshopsnetwork.domain.docs;

import club.psvm.smallshopsnetwork.domain.elements.RawStuff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class RecipeLine {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(targetEntity = Recipe.class)
    Recipe recipe;

    @ManyToOne(targetEntity = RawStuff.class)
    RawStuff rawStuff;

    BigDecimal quantity;

    boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public RawStuff getRawStuff() {
        return rawStuff;
    }

    public void setRawStuff(RawStuff rawStuff) {
        this.rawStuff = rawStuff;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
