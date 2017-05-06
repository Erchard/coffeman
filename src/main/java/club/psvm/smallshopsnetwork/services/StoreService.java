package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.actors.Store;
import club.psvm.smallshopsnetwork.repositories.StoreRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 06.05.17.
 */

@Service
public class StoreService {

    private StoreRepositories storeRepositories;

    public List<Store> findAll() {

        List<Store> storeList = (List<Store>) storeRepositories.findAll();
        if (storeList != null) {
           storeList.removeIf(Store::isDeleted);
           return storeList;
        }
        return new ArrayList<>();
    }

    @Autowired
    public void setStoreRepositories(StoreRepositories storeRepositories) {
        this.storeRepositories = storeRepositories;
    }
}
