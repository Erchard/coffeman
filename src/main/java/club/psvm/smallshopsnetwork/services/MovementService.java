package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.repositories.MovementLineRepository;
import club.psvm.smallshopsnetwork.repositories.MovementStuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arsenguzhva on 5/2/2017.
 */
@Service
public class MovementService {

    @Autowired
    MovementStuffRepository movementStuffRepository;

    @Autowired
    MovementLineRepository movementLineRepository;

}
