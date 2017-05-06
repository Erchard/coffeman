package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.actors.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */

@Repository
public interface StoreRepositories extends CrudRepository<Store,Long> {
    List<Store> findAllByName(String name);
}
