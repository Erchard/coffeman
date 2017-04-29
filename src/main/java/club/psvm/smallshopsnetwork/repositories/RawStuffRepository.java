package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.elements.RawStuff;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface RawStuffRepository extends CrudRepository<RawStuff,Long> {
    List<RawStuff> findAllByName(String name);
}
