package com.bhp.catalog.services.impl;/*my name is udi sasson and the date is 30/11/2020 */


import com.bhp.catalog.beans.Item;
import com.bhp.catalog.beans.ItemType;
import com.bhp.catalog.repo.ItemRepo;
import com.bhp.catalog.services.interfaces.AdminService;
import com.bhp.catalog.services.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class AdminServiceImpl implements AdminService, ItemService {

    private final ItemRepo itemRepo;


    @Override
    public void deleteItem(Item item,Long id) throws InvalidEntityException {
        if(id == getOneItem(id).getId()){
            itemRepo.delete(item);
            return;
        }
        throw new InvalidEntityException("cannot delete - id not exist");


    }

    @Override
    public Item getOneItem(Long id) {
        return itemRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public void saveItem(Item item) {
        itemRepo.save(item);
    }


    @Override
    public void updateItem(Long id,Item item) throws InvalidEntityException {
        if(id == getOneItem(id).getId()){
            item.setId(id);
            itemRepo.saveAndFlush(item);
            return;
        }
            throw new InvalidEntityException("Cannot update not existing id");

    }

    @Override
    public long countItem() {
        return itemRepo.count();
    }

}
