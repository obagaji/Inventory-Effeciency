package com.jtc.Inventory.Effeciency.inventService;

import com.jtc.Inventory.Effeciency.inventDto.ItemsSoldDto;
import com.jtc.Inventory.Effeciency.inventoryEntities.ItemsSold;
import com.jtc.Inventory.Effeciency.inventDto.SalesDetails;
import com.jtc.Inventory.Effeciency.inventoryRepos.ItemSoldRepository;
import com.jtc.Inventory.Effeciency.supplierInvent.SalesdetailSupplier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
@Validated
public class ItemsSoldServices {

    private static Logger LOGGER =  Logger.getLogger("ItemsSoldServices");

    @Autowired
    private ItemSoldRepository itemSoldRepository;

    // Method to get all the sale made. returning a list of ItemsSold entity.
    public List<ItemsSold> findAllSale()
    {
        Optional<List<ItemsSold>> optionalList = Optional.of((List<ItemsSold>) itemSoldRepository.findAll());
        if (optionalList.isEmpty()){
            List< ItemsSold> list = List.of(new ItemsSold());
            LOGGER.info("value: " + itemSoldRepository.findAll() );
            return list;
        }
        else {
        return (List<ItemsSold>) itemSoldRepository.findAll();}
    }
    // this method will return from the repository the id of the customer with the highest purchase.
    public SalesDetails findSalesDetail(int salesId)
    {
        SalesdetailSupplier sd = new SalesdetailSupplier();
        return  null;//itemSoldRepository.getSalesDetails(salesId).orElse(sd.get());
    }

    public void addToSalesItem(ItemsSold itemsSold)
    {
        itemSoldRepository.save(itemsSold);

    }
  //  public int getMaximumSales()
   /* {
        return itemSoldRepository.getTheMaximumPurchase();
    }*/
}
