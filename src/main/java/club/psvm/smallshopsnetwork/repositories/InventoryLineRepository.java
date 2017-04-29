package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.docs.Inventory;
import club.psvm.smallshopsnetwork.domain.docs.InventoryLine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface InventoryLineRepository extends CrudRepository<InventoryLine, Long> {
    List<InventoryLine> findAllByInventoryAndDeleted(Inventory inventory, boolean deleted);
}
