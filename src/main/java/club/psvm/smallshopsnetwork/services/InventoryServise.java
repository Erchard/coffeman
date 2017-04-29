package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.docs.Inventory;
import club.psvm.smallshopsnetwork.domain.docs.InventoryLine;
import club.psvm.smallshopsnetwork.domain.docs.InvoiceLine;
import club.psvm.smallshopsnetwork.repositories.InventoryLineRepository;
import club.psvm.smallshopsnetwork.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Service
public class InventoryServise {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    InventoryLineRepository inventoryLineRepository;


    public List<Inventory> findAll() {
        List<Inventory> inventoryList = (List<Inventory>) inventoryRepository.findAll();
        if (inventoryList != null) {
            inventoryList.removeIf(Inventory::isDeleted);
            inventoryList.forEach(inventory -> fillLines(inventory));
            return inventoryList;

        } else
            return new ArrayList<>();

    }

    private Inventory fillLines(Inventory inventory) {

        List<InventoryLine> lineList = inventoryLineRepository.findAllByInventoryAndDeleted(inventory, false);
        if(lineList!=null){
            inventory.setInventoryLineList(lineList);
        }
        return inventory;
    }

}
