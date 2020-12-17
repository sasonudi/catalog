package com.bhp.catalog.services.interfaces;/*my name is udi sasson and the date is 30/11/2020 */

import com.bhp.catalog.beans.Item;
import com.bhp.catalog.services.impl.InvalidEntityException;
import com.bhp.catalog.services.impl.InvalidOperationExceptionException;

import java.util.List;

public interface ItemService {

    void saveItem(Item item) throws  InvalidEntityException,  InvalidOperationExceptionException;
    void updateItem(Long id,Item item) throws InvalidEntityException, InvalidOperationExceptionException;
    long countItem();
    Item getOneItem(Long id) throws InvalidOperationExceptionException, InvalidEntityException;
    List<Item> getAllItems() throws InvalidOperationExceptionException;

}
