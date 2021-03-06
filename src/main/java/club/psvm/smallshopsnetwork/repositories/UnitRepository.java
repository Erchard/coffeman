package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.elements.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JAVA-P on 28.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/
public interface UnitRepository extends CrudRepository<Unit,Long> {
    List<Unit> findAllByNameAndDeleted(String name,boolean deleted);
}
