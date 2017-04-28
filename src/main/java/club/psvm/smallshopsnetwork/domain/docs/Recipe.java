package club.psvm.smallshopsnetwork.domain.docs;

import club.psvm.smallshopsnetwork.domain.Product;

import javax.persistence.*;
import java.math.BigDecimal;
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
public class Recipe {

    @Id
    @GeneratedValue
    Long id;

    @OneToOne(targetEntity = Product.class)
    Product product;

    BigDecimal quantity;

    @Transient
    List<RecipeLine> recipeLineList = new ArrayList<>();

    boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public List<RecipeLine> getRecipeLineList() {
        return recipeLineList;
    }

    public void setRecipeLineList(List<RecipeLine> recipeLineList) {
        this.recipeLineList = recipeLineList;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
