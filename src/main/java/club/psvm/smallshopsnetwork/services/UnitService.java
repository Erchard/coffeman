package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.elements.Unit;
import club.psvm.smallshopsnetwork.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAVA-P on 28.04.2017.
 */
 
 /* Создано в www.gateon.net
 * Все права на данный программный код принадлежат компании GateOn
 * Created by www.gateon.net
 * All rights to the software code are owned by GateOn
*/
@Service
public class UnitService {

    @Autowired
    UnitRepository unitRepository;

    public List<Unit> findAll() {
        List<Unit> unitList = (List<Unit>) unitRepository.findAll();
        if (unitList == null) return new ArrayList<>();
        unitList.removeIf(Unit::isDeleted);
        return unitList;
    }

    public Unit findOne(Long id) {
        Unit unit = unitRepository.findOne(id);

        if (unit == null) return new Unit();

        return unit;
    }

    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    public void delete(Long id) {
        Unit unit = unitRepository.findOne(id);
       if(unit != null) delete(unit);
    }

    public void delete(Unit unit) {
        if(unit==null) return;
        unit.setDeleted(true);
        unitRepository.save(unit);
    }

}
