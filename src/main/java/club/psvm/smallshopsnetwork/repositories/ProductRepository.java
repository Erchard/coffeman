package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface ProductRepository extends CrudRepository<Product,Long>{
}
