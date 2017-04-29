package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface ContractorRepository extends CrudRepository<Contractor,Long>{
    List<Contractor> findAllByNameAndDeleted(String name, boolean deleted);
}
