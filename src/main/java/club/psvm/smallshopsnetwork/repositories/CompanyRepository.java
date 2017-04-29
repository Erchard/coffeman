package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.actors.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface CompanyRepository extends CrudRepository<Company,Long> {
}
