package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.docs.MovementLine;
import club.psvm.smallshopsnetwork.domain.docs.MovementStuff;
import club.psvm.smallshopsnetwork.repositories.MovementLineRepository;
import club.psvm.smallshopsnetwork.repositories.MovementStuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arsenguzhva on 5/2/2017.
 */
@Service
public class MovementService {

    @Autowired
    MovementStuffRepository movementStuffRepository;

    @Autowired
    MovementLineRepository movementLineRepository;

    public List<MovementStuff> findAll(){
        List<MovementStuff> movementStuffList = (List<MovementStuff>) movementStuffRepository.findAll();
        //TODO: filter adn other
return movementStuffList;
    }

}
