package com.bhp.catalog.services.impl;/*my name is udi sasson and the date is 30/11/2020 */

import com.bhp.catalog.beans.Item;
import com.bhp.catalog.beans.ItemType;
import com.bhp.catalog.repo.ItemRepo;
import com.bhp.catalog.services.interfaces.ElectricityService;
import com.bhp.catalog.services.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricityServiceImpl implements ElectricityService, ItemService {

    private final ItemRepo itemRepo;

    @Override
    public void saveItem(Item item) throws InvalidOperationExceptionException {
        if(!item.getItemType().equals(ItemType.ELECTRICITY)){
            throw new InvalidOperationExceptionException("cannot add an item outside your domain");
        }
        itemRepo.save(item);

    }

    @Override
    public void updateItem(Long id,Item item) throws InvalidOperationExceptionException, InvalidEntityException {
        if(!item.getItemType().equals(ItemType.ELECTRICITY)){
            throw new InvalidOperationExceptionException("cannot update an item outside your domain");
        }
        if(itemRepo.findById(id).isEmpty()){
            throw  new InvalidEntityException("Cannot update not existing id");
        }
        itemRepo.saveAndFlush(item);

    }

    @Override
    public long countItem() {

        return itemRepo.countType("ELECTRICITY");
    }

    @Override
    public Item getOneItem(Long id) throws InvalidEntityException, InvalidOperationExceptionException {
        if( !itemRepo.getOne(id).getItemType().equals(ItemType.ELECTRICITY)){
            throw new InvalidOperationExceptionException("cannot update an item outside your domain");
        }
        if(itemRepo.findById(id).isEmpty()) {
            throw new InvalidEntityException("Item not found");
        }

        return itemRepo.findById(id).orElseThrow(() -> new InvalidEntityException("Item not found"));

    }

    @Override
    public List<Item> getAllItems()  {
        List<Item> electricList = new ArrayList<>();
        for (Item itm: itemRepo.findAll()) {
           if (itm.getItemType().equals(ItemType.ELECTRICITY)){
              electricList.add(itm);
           }

        }
        return electricList ;
    }
}
