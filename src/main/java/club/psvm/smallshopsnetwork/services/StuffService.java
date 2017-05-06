package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.elements.Stuff;
import club.psvm.smallshopsnetwork.repositories.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 06.05.17.
 */

@Service
public class StuffService {

    private StuffRepository stuffRepository;

    public List<Stuff> findAll() {

        List<Stuff> stuffList = (List<Stuff>) stuffRepository.findAll();
        if(stuffList != null) {
            stuffList.removeIf(Stuff::isDeleted);
            return stuffList;
        }
        return new ArrayList<>();
    }

    @Autowired
    public void setStuffRepository(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }
}
