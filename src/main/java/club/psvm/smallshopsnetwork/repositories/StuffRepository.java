package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.elements.Stuff;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface StuffRepository extends CrudRepository<Stuff,Long>{
    List<Stuff> findAllByName(String name);
}