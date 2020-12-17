package com.bhp.catalog.controller;/*my name is udi sasson and the date is 30/11/2020 */

import com.bhp.catalog.beans.Item;
import com.bhp.catalog.services.impl.InvalidEntityException;
import com.bhp.catalog.services.impl.InvalidOperationExceptionException;
import com.bhp.catalog.services.interfaces.ItemService;
import com.bhp.catalog.services.interfaces.SportService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sport")
public class SportController {
    

    private final SportService sportService;


    @SneakyThrows
    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@RequestBody Item item)
    {
        sportService.saveItem(item);
    }

    @SneakyThrows
    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable Long id,@RequestBody  Item item)  {
        sportService.updateItem(id,item);

    }

    @SneakyThrows
    @GetMapping("/items/count")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> countItem() {

        return ResponseEntity.ok(sportService.countItem());
    }
    @SneakyThrows
    @GetMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Item> getAllItems() {

        return sportService.getAllItems();
    }

    @SneakyThrows
    @GetMapping("/items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item getOneItem(@PathVariable Long id) throws InvalidOperationExceptionException, InvalidEntityException {

        return sportService.getOneItem(id);
    }
}
