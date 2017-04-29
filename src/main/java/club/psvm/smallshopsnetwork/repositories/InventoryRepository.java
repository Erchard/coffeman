package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.docs.Inventory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
