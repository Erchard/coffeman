package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.actors.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface StoreRepositories extends CrudRepository<Store,Long> {
    List<Store> findAllByName(String name);
}
