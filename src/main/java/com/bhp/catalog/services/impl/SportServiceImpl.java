package com.bhp.catalog.services.impl;/*my name is udi sasson and the date is 30/11/2020 */

import com.bhp.catalog.beans.Item;
import com.bhp.catalog.beans.ItemType;
import com.bhp.catalog.repo.ItemRepo;
import com.bhp.catalog.services.interfaces.ItemService;
import com.bhp.catalog.services.interfaces.SportService;;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SportServiceImpl  implements SportService, ItemService {

     private final ItemRepo itemRepo;

    @Override
    public void saveItem(Item item) throws InvalidOperationExceptionException {
        if(!item.getItemType().equals(ItemType.SPORTS)){
            throw new InvalidOperationExceptionException("cannot add an item outside your domain");
        }
        itemRepo.save(item);

    }

    @Override
    public void updateItem(Long id,Item item) throws InvalidOperationExceptionException, InvalidEntityException {
        if(!item.getItemType().equals(ItemType.SPORTS)){
            throw new InvalidOperationExceptionException("cannot update an item outside your domain");
        }
        if(itemRepo.findById(id).isEmpty()){
           throw  new InvalidEntityException("Cannot update not existing id");
        }

        itemRepo.saveAndFlush(item);

    }

    @Override
    public long countItem() {

        return itemRepo.countType("SPORTS");
    }


    @SneakyThrows
    @Override
    public Item getOneItem(Long id)  {
        if( !itemRepo.getOne(id).getItemType().equals(ItemType.SPORTS)){
            throw new InvalidOperationExceptionException("cannot update an item outside your domain");
        }
        return itemRepo.findById(id).orElseThrow(() -> new InvalidEntityException("Item not found"));

    }

    @Override
    public List<Item> getAllItems() {
        List<Item> sportList = new ArrayList<>();
        for (Item itm: itemRepo.findAll()) {
            if (itm.getItemType().equals(ItemType.SPORTS)){
                sportList.add(itm);
            }

        }
        return sportList ;
    }
}
