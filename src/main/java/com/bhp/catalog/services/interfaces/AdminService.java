package com.bhp.catalog.services.interfaces;/*my name is udi sasson and the date is 29/11/2020 */

import com.bhp.catalog.beans.Item;
import com.bhp.catalog.services.impl.InvalidEntityException;

public interface AdminService extends ItemService {

    //void saveItem(Item item);
  ///  void updateItem(Item item);
    void deleteItem(Item item, Long id) throws InvalidEntityException;
   // Item getOneItem(Long id);
  //  List<Item> getAllItems();
   // long countItem();
}
