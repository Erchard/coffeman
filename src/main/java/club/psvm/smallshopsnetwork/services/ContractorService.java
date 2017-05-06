package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.actors.Contractor;
import club.psvm.smallshopsnetwork.repositories.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 30.04.17.
 */

@Service
public class ContractorService {

    private ContractorRepository contractorRepository;


    public Contractor findOneById(Long id) {
        Contractor contractor = contractorRepository.findOne(id);
        return contractor;
    }

    public Contractor findOneByName(String name) {

        Contractor contractor = contractorRepository.findOneByName(name);
        if (contractor == null) {
//            return new Contractor(name, );
            return new Contractor();
        }

        return contractor;
    }

    public void save(Contractor contractor) {
        contractorRepository.save(contractor);
    }


    public List<Contractor> findAll() {
        List<Contractor> contractorList = (List<Contractor>) contractorRepository.findAll();
        if(contractorList==null || contractorList.size()==0){
            return new ArrayList<>();
        }
        else {
            contractorList.removeIf(Contractor::isDeleted);
//            contractorList.forEach(contractor -> fillLines(contractor));
            return contractorList;
        }
    }

    public void remove(Long id) {

        Contractor isHidden = contractorRepository.findOne(id);
        isHidden.setDeleted(true);
        contractorRepository.save(isHidden);
    }



    @Autowired
    public void setContractorRepository(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }
}
