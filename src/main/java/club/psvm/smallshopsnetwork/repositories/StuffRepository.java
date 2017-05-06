package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.elements.Stuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */

@Repository
public interface StuffRepository extends CrudRepository<Stuff,Long>{
    List<Stuff> findAllByName(String name);
}
