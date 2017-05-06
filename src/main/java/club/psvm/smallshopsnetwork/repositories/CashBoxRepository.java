package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.elements.CashBox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arsenguzhva on 4/29/2017.
 */

@Repository
public interface CashBoxRepository extends CrudRepository<CashBox,Long>{
}
