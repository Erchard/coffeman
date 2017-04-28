package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.Unit;
import club.psvm.smallshopsnetwork.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
public class InitService {

     @Autowired
    UnitRepository unitRepository;

     public void init(){
         List<Unit> unitList = (List<Unit>) unitRepository.findAll();
         if(unitList==null || unitList.size()==0){
             List<Unit> units = new ArrayList<>();
             units.add(new Unit("кг"));
             units.add(new Unit("шт"));
             units.add(new Unit("л"));
             unitRepository.save(units);
         }

     }

}
