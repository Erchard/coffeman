package club.psvm.smallshopsnetwork.repositories;

import club.psvm.smallshopsnetwork.domain.actors.Store;
import club.psvm.smallshopsnetwork.domain.docs.MovementStuff;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
public interface MovementStuffRepository extends CrudRepository<MovementStuff, Long>{
//    List<MovementStuff> findAllByStoreAndDeleted(Store store, boolean deleted);
//    List<MovementStuff> findAllByStoreAndDeletedAAndDateTimeBeforeAndActual(Store store, boolean deleted, LocalDateTime dateTime,boolean actual);
}
