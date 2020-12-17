package com.bhp.catalog.controller;/*my name is udi sasson and the date is 30/11/2020 */


import com.bhp.catalog.beans.Item;
import com.bhp.catalog.services.interfaces.ElectricityService;
import com.bhp.catalog.services.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("electric")
public class ElectricityController  {


    private final ElectricityService electricService;


    @SneakyThrows
    @PostMapping("/items/item")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@RequestBody Item item)
    {
        electricService.saveItem(item);
    }


    @SneakyThrows
    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable Long id,@RequestBody  Item item)  {
        electricService.updateItem(id,item);

    }

    @SneakyThrows
    @GetMapping("/items/count")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> countItem() {

        return ResponseEntity.ok(electricService.countItem());
    }
    @SneakyThrows
    @GetMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Item> getAllItems() {
        return electricService.getAllItems();
    }



    @SneakyThrows
    @GetMapping("/items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item getOneItem(@PathVariable Long id) {

        return electricService.getOneItem(id);
    }
}
