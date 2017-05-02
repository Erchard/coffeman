package club.psvm.smallshopsnetwork.services;

import club.psvm.smallshopsnetwork.domain.actors.Store;
import club.psvm.smallshopsnetwork.domain.docs.*;
import club.psvm.smallshopsnetwork.domain.elements.RawStuff;
import club.psvm.smallshopsnetwork.domain.elements.Stuff;
import club.psvm.smallshopsnetwork.repositories.InventoryLineRepository;
import club.psvm.smallshopsnetwork.repositories.InventoryRepository;
import club.psvm.smallshopsnetwork.repositories.InvoiceRepository;
import club.psvm.smallshopsnetwork.repositories.MovementStuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by arsenguzhva on 4/29/2017.
 */
@Service
public class InventoryServise {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    InventoryLineRepository inventoryLineRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    MovementStuffRepository movementStuffRepository;

    @Autowired
    InvoiceService invoiceService;


    public List<Inventory> findAll() {
        List<Inventory> inventoryList = (List<Inventory>) inventoryRepository.findAll();
        if (inventoryList != null) {
            inventoryList.removeIf(Inventory::isDeleted);
            inventoryList.forEach(inventory -> fillLines(inventory));
            return inventoryList;

        } else
            return new ArrayList<>();

    }

    public Inventory findOne(Long id){
        Inventory inventory = inventoryRepository.findOne(id);
        fillLines(inventory);
        return inventory;
    }

    private Inventory fillLines(Inventory inventory) {

        List<InventoryLine> lineList = inventoryLineRepository.findAllByInventoryAndDeleted(inventory, false);
        if (lineList != null) {
            inventory.setInventoryLineList(lineList);
        }else
            recalc(inventory);
        return inventory;
    }

    public Inventory recalc(Inventory inventory) {
        Store store = inventory.getStore();
        LocalDateTime dateTime = inventory.getDateTime();

        List<Invoice> invoiceList = invoiceRepository.findAllByStoreAndDeletedAndDateTimeBeforeAndActual(store, false, dateTime, true);
//        List<MovementStuff> movementStuffList = movementStuffRepository.findAllByStoreAndDeletedAAndDateTimeBeforeAndActual(store, false, dateTime, true);

        Map<RawStuff, InventoryLine> rawStuffInventoryLineMap = new Hashtable<>();

        for (Invoice invoice : invoiceList) {
            invoiceService.fillLines(invoice);
            List<InvoiceLine> invoiceLineList = invoice.getInvoiceLineList();
            for (InvoiceLine invoiceLine : invoiceLineList) {
                Stuff stuff = invoiceLine.getStuff();
                RawStuff rawStuff = stuff.getRawStuff();
                BigDecimal rawSumm = invoiceLine.getTotal();
                BigDecimal rawQuantity = invoiceLine.getQuantity().multiply(stuff.getRawFactor());
//                BigDecimal rawPrice = rawSumm.divide(rawQuantity);

                if (rawStuffInventoryLineMap.containsKey(rawStuff)) {
                    InventoryLine inventoryLine = rawStuffInventoryLineMap.get(rawStuff);
                    rawSumm = rawSumm.add(inventoryLine.getAccountingSumm());
                    rawQuantity = rawQuantity.add(inventoryLine.getExpectedQuantity());

                    inventoryLine.setAccountingSumm(rawSumm);
                    inventoryLine.setExpectedQuantity(rawQuantity);

                } else {
                    InventoryLine inventoryLine = new InventoryLine();

                    inventoryLine.setRawStuff(rawStuff);
                    inventoryLine.setAccountingSumm(invoiceLine.getTotal());
                    inventoryLine.setExpectedQuantity(rawQuantity);
                    inventoryLine.setInventory(inventory);
                    inventoryLine.setRealQuantity(new BigDecimal("0.00"));
                    rawStuffInventoryLineMap.put(rawStuff, inventoryLine);

                }
            }
        }

        //TODO: foreach movementStuffList

        List<InventoryLine> oldInventaryLineList = inventory.getInventoryLineList();
        oldInventaryLineList.forEach(inventoryLine -> {
            inventoryLine.setDeleted(true);
        });
        inventoryLineRepository.save(oldInventaryLineList);

        List<InventoryLine> inventoryLineList = new ArrayList<>(  rawStuffInventoryLineMap.values());
        inventoryLineRepository.save(inventoryLineList);
        inventory.setInventoryLineList(inventoryLineList);

        return inventory;
    }

}
